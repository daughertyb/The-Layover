<template>
  <div>
    <h1>You Have Made It to The Promised Land</h1>
    <title>Example</title>
    {{$store.state.selectedLandmarks}}

    <header>Header</header>
    <div id="main">
      <article>Article</article>
      <nav>Nav</nav>
      <aside>Aside</aside>
    </div>
    <footer>Footer</footer>
  </div>
</template>

<script>
export default {

};
</script>

<style scoped>
* {
  box-sizing: border-box;
}
body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
  margin: 0;
}
#main {
  display: flex;
  flex: 1;
}
#main > article {
  flex: 1;
}
#main > nav,
#main > aside {
  flex: 0 0 20vw;
  background: beige;
}
#main > nav {
  order: -1;
}
header,
footer {
  background: yellowgreen;
  height: 20vh;
}
header,
footer,
article,
nav,
aside {
  padding: 1em;
}
</style>