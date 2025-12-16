import React, { useState } from 'react';
import logo from './logo.svg';
import axios from "axios";
import { Button, Grid, TextField } from '@mui/material';
import { Items } from 'openai/resources/conversations/items';

function App() {
  const [input, setInput] = useState("");
  const [result, setResult] = useState("");
  const [loading, setLoading] = useState(false);

  const refine = async () => {
    setLoading(true);

    let data = JSON.stringify({
      "text": input
    });

    axios
      .post("http://localhost:8080/api/refine", input)
      .then((response: any) => {
          setResult(response.data);
          setLoading(false);
      })
      .catch((err: any) => {
          setResult("The input can not be empty!")
          setLoading(false);
      });

    setLoading(false);
  };

  return (
    <div style={{ padding: 20, width: "100%" }}>
      <Grid size={12}>
        <p style={{ height: '100%', boxSizing: 'border-box' }}>{result}</p>
      </Grid>
      <TextField
        style={{width: "70%"}}
        multiline
        rows={4}
        value={input}
        onChange={e => setInput(e.target.value)}
      />
      <br />
      <Button style={{"margin": 5}} variant="outlined" onClick={refine} disabled={loading}>
        {loading ? "Refining..." : "Refine"}
      </Button>
    </div>
  );
}

export default App;