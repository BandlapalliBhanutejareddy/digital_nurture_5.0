function Greeting({ name }) {
  return <h1>Hello, {name}!</h1>;
}

export default function App() {
  return (
    <main>
      <Greeting name="Digital Nurture" />
      <p>Simple component rendering for the basics exercise.</p>
    </main>
  );
}
