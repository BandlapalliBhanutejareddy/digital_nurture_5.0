import { useState } from 'react';

export default function App() {
  const [form, setForm] = useState({ name: '', email: '' });
  const [message, setMessage] = useState('');

  function handleSubmit(event) {
    event.preventDefault();
    setMessage(`Submitted: ${form.name} | ${form.email}`);
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name
        <input value={form.name} onChange={(e) => setForm({ ...form, name: e.target.value })} />
      </label>
      <label>
        Email
        <input value={form.email} onChange={(e) => setForm({ ...form, email: e.target.value })} />
      </label>
      <button type="submit">Submit</button>
      <p>{message}</p>
    </form>
  );
}
