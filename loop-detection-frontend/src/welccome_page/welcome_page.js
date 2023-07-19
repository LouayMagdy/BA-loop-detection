import "./Welcome_page.css"
import Form from "../form/Form";
import Result from "../result/Result";
import {useEffect, useState} from "react";

export default function Welcome_page(){
    let [state, setState] = useState('not uploaded yet')
    let [csvData, setCsvData] = useState([]);
    let [nodeDict, setNodeDict] = useState({})


    const updateState = (newState) => {setState(newState);};
    const updateCSV = (newContent) => {
        setCsvData(newContent);
    };
    useEffect(async () => {
        if(csvData === []) return;
        let dict = {}
        let numericEdges = []
        let counter = 0
        csvData.forEach(function (edge){
            edge.forEach(function (node){
                if(!(node in dict)) dict[node] = counter++
            })
            numericEdges.push([dict[edge[0]], dict[edge[1]]])
        })
        setNodeDict(dict)
        // let loops = await fetch()
    }, [csvData])

    return <div className={"welcome-page"}>
        <Form state={state} updateState={updateState} updateCSV={updateCSV} />
        <Result state={state}/>
    </div>
}