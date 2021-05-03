import styles from './styles.module.scss';

export function Background() {
  return (
    <div>
      <div className={styles.context}>
        <h1>VS</h1>
      </div>

      <div className={styles.area} >
        <ul className={styles.circles}>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
        </ul>
      </div >
    </div>
  )
}