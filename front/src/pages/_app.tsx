import { Header } from '../components/Header/Header'
import Head from 'next/head';
import { Background } from '../components/Background/Background'

import '../styles/global.scss'
import styles from '../styles/app.module.scss'

function MyApp({ Component, pageProps }) {
  return (
    <div className={styles.wrapper}>
      <Head>
        <link rel="icon" href="/logo.png" />
        <title>DevDay FATEC 2021</title>
      </Head>
      <main>
        <Header />
        {/* <Background /> */}
        <Component {...pageProps} />
      </main>
    </div>
  )
}

export default MyApp
