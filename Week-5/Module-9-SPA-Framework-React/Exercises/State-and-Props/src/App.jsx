import React, { useState } from 'react';

export default function App() {
    const [count, setCount] = useState(0);

    return (
        <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
            <h1>State and Props</h1>
            <p>Welcome to the implementation of State and Props.</p>
            <button onClick={() => setCount(count + 1)}>
                Interactions: {count}
            </button>
        </div>
    );
}
