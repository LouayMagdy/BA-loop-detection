import './Result.css'
import { DataSet, Network } from "vis";
import {useEffect, useRef, useState} from "react";

export default function Result(props){
    console.log(props.loops)
    const graphRef = useRef(null);
    let[index, setIndex] = useState(1);

    const increment = () => {setIndex(index + 1);};
    const decrement = () => {setIndex(index - 1);};

    useEffect(() => {
        setIndex(0)
    }, [props.loops])

    useEffect(() => {
        if(props.loops[index] !== undefined){
            const nodeIdsSet = new Set();
            let edgesArr = props.loops[index]
            edgesArr.forEach((edge) => {
                nodeIdsSet.add(edge[0]);
                nodeIdsSet.add(edge[1]);
            });
            const nodeIdsArray = Array.from(nodeIdsSet);

            const nodesArray = nodeIdsArray.map((nodeId) => {
                return { id: nodeId, label: `Node ${nodeId}` };
            });

            const edgesArrayWithData = edgesArr.map((edge) => {
                return { from: edge[0], to: edge[1], arrows: "to", color: 'green' };
            });


            const nodes = new DataSet(nodesArray);
            const edges = new DataSet(edgesArrayWithData);
            console.log(nodes, edges)

            const data = { nodes, edges };
            const options = {};

            new Network(graphRef.current, data, options);
        }
    }, [props.loops, index]);

        return <div className={"result"} style={{bottom: 20, width: window.innerWidth / 2 - 30, left: window.innerWidth / 2 + 15, top: 20}}>
            <div ref={graphRef} className={'graph'} style={{paddingTop: window.innerHeight / 3}} />
            {
                props.state === 'processed'?
                    <div className={"paging-container"}>
                        <button className={'paging-button'} onClick={decrement} disabled={index === 0}>Prev</button>
                        <span className={'paging-page-number'}>{index + 1}/{props.loops.length}</span>
                        <button className={'paging-button'} onClick={increment} disabled={index >= props.loops.length - 1}>Next</button>
                    </div> : null
            }
        </div>

    // return <div className={"result"} style={{bottom: 20, width: window.innerWidth / 2 - 30, left: window.innerWidth / 2 + 15, top: 20}}>
    //     <h2 className={"message"}> {props.state} </h2>
    // </div>
}