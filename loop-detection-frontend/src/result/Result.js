import './Result.css'

export default function Result(props){
    console.log(props);
    if(props.state === "processed"){
        return <div className={"result"} style={{bottom: 20, width: window.innerWidth / 2 - 30, left: window.innerWidth / 2 + 15, top: 20}}>
            graph
        </div>
    }
    return <div className={"result"} style={{bottom: 20, width: window.innerWidth / 2 - 30, left: window.innerWidth / 2 + 15, top: 20}}>
        <h2 className={"message"}> {props.state} </h2>
    </div>
}