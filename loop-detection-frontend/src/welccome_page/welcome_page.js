import "./Welcome_page.css"
import Form from "../form/Form";
import Result from "../result/Result";
import {useEffect, useState} from "react";

export default function Welcome_page(){
    let [state, setState] = useState('not uploaded yet')
    let [csvData, setCsvData] = useState([]);
    let [loops, setLoops] = useState([])


    const updateState = (newState) => {setState(newState);};
    const updateCSV = (newContent) => {
        setCsvData(newContent);
    };

    let getLoops = async () => {
        let dict = {}
        let numericEdges = []
        let counter = 0
        csvData.forEach(function (edge){
            edge.forEach(function (node){
                if(!(node in dict)) {
                    console.log(node, counter);
                    dict[node] = counter++
                }
            })
            numericEdges.push([dict[edge[0]], dict[edge[1]]])
        })
        console.log(dict)
        dict = reverseMap(dict)
        await fetch("http://localhost:8080/loop-detection-server/detect",{
            method: "POST",
            headers:{'Content-Type': 'application/json'},
            body: JSON.stringify({"edges": numericEdges})
        }).then(response => response.json())
            .then(data => {
                console.log(data.loops, dict)
                let loops = data.loops.map( loop => loop.map(e => dict[e]))
                console.log(loops)
                for (let i = 0; i < loops.length; i++) {
                    const result = [];
                    for (let j = 0; j < loops[i].length - 1; j++) {
                        result.push([loops[i][j], loops[i][j + 1]]);
                    }
                    loops[i] = result
                }
                setLoops(loops)
                setState("processed")
            })
    }

    useEffect(() => {
        if(csvData !== null && csvData.length > 0){
            getLoops().then(() => {})
        }
    }, [csvData])

    return <div className={"welcome-page"}>
        <Form state={state} updateState={updateState} updateCSV={updateCSV} />
        <Result state={state} loops={loops}/>
    </div>


    function reverseMap(obj) {
        var reversed = {};
        for (var key in obj) {
            reversed[obj[key]] = key;
        }
        return reversed;
    }
}