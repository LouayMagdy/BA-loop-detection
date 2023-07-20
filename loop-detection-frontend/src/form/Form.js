import './Form.css'
import logo from "../images/logo.png";
import {useRef} from "react";

export default function Form(props){

    const hiddenFileInput = useRef(null);
    const handleButtonClick = event => {hiddenFileInput.current.click();};
    const handleFileUpload = async (event) => {
        const fileUploaded = event.target.files[0];
        if(fileUploaded === undefined) return
        props.updateState("processing...")
        const text = await fileUploaded.text();
        let rows = text.split('\n');
        rows = rows.map(str => str.replace(/\r/g, '').split(','))
        props.updateCSV(rows)
    };

    return <div className={"my-form"} style={{bottom: 20, width: window.innerWidth / 2 - 10, left: 10, top: 20}}>
        <div className={'title'}>
            <h1>Loop Sensor</h1>
            <img src={logo}/>
            <p> A Graph Sketching and Loop Detection Tool for Network Analysis</p>

            <div className={"rules"}>
                <h3 className={"rules-title"}> Rules: </h3>
                <ul className={"rules-items"}>
                    <li> Allowed format is CSV only. </li>
                    <li> The CSV file should only have 2 columns: A for source, B for destination. </li>
                    <li> Do not give names to columns or titles will be considered as nodes. </li>
                </ul>
            </div>

            <button className={"upload-button"} onClick={handleButtonClick} disabled={props.state === 'processing...'}>
                Upload a CSV File
            </button>
            <input
                type="file"
                ref={hiddenFileInput}
                style={{ display: 'none'}}
                onChange={handleFileUpload}
            />
        </div>
    </div>
}