import React, { useState } from 'react';

export default function App() {
    const [count, setCount] = useState(0);

    return (
        <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
            <h1>Routing in React</h1>
            <p>Welcome to the implementation of Routing in React.</p>
            <button onClick={() => setCount(count + 1)}>
                Interactions: {count}
            </button>
        </div>
    );
}
