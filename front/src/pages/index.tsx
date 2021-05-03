import { GetStaticProps } from 'next';
import { api } from '../Services/api';
import styles from './home.module.scss'
import Image from 'next/image';

type Character = {
  id: string;
  name: string;
  thumbnail: string;
  powerstats: PowerStats;
};

type PowerStats = {
  intelligence: number,
  strength: number,
  speed: number,
  durability: number,
  power: number,
  combat: number
}

type Fight = {
  id: string,
  date: string,
  winnerName: string,
  winnerPicture: string,
  loserName: string,
  loserPicture: string
}

type HomeProps = {
  fightHistory: Fight[];
  fightHeroes: Character[];
};

export default function Home({ fightHistory, fightHeroes }: HomeProps) {
  return (
    <div className={styles.homepage}>
      <section className={styles.fightHeroes}>
        <h2>Iniciar Nova Luta</h2>
        <ul>
          {fightHeroes.map((character) => {
            return (
              <li key={character.id}>
                <Image
                  width={192}
                  height={192}
                  src={character.thumbnail}
                  alt={character.name}
                  objectFit="cover"
                />
                <div className={styles.characterDetails}>
                  <h1>{character.name}</h1>
                  <p>Força: {character.powerstats.strength}</p>
                  <p>Inteligência: {character.powerstats.intelligence}</p>
                  <p>Velocidade: {character.powerstats.strength}</p>
                  <p>Combate: {character.powerstats.combat}</p>
                </div>
                <button type="button">
                  <img src="/shuffle.svg" alt="Encontrar Novo Personagem" />
                </button>
              </li>
            );
          })}
        </ul>
      </section>
      <div className={styles.newFightOptions}>
        <button type="button">Lutar</button>
      </div>


      <section className={styles.fightHistory}>
        <h2>Histórico de Lutas</h2>
        <table cellSpacing={0}>
          <thead>
            <th>Vencedor</th>
            <th></th>
            <th>Perdedor</th>
            <th></th>
            <th>Data</th>
            <th>Jogador</th>
          </thead>
          <tbody>
            {fightHistory.map(fight => {
              return (
                <tr key={fight.id}>
                  <td>
                    <Image
                      width={120}
                      height={120}
                      src={fight.winnerPicture}
                      alt={fight.winnerName}
                      objectFit="cover"
                    />
                  </td>
                  <td>
                    <p>{fight.winnerName}</p>
                  </td>
                  <td>
                    <Image
                      width={120}
                      height={120}
                      src={fight.loserPicture}
                      alt={fight.loserName}
                      objectFit="cover"
                    />
                  </td>
                  <td>
                    <p>{fight.loserName}</p>
                  </td>
                  <td>
                    <p>{new Date().toDateString()}</p>
                  </td>
                  <td>
                    Teste
                  </td>
                </tr>
              )
            })}
          </tbody>

        </table>
      </section>
    </div>

  );
}

export const getStaticProps: GetStaticProps = async () => {
  const fighters = await api.get('/fight/fighters');
  const hero = fighters.data.hero
  const villain = fighters.data.villain

  const fightersData = [hero, villain]

  const history = await api.get('/fight');
  const fightHistoryData = history.data;

  const fightHeroes =  fightersData.map(fighter => {
    return {
      id: fighter.id,
      name: fighter.name,
      thumbnail: fighter.images.md,
      powerstats: fighter.powerstats
    }
  });

  const fightHistory = fightHistoryData.map(fight => {
    return {
      id: fight.id,
      winnerName: fight.winnerName,
      winnerPicture: fight.winnerPicture,
      loserName: fight.loserName,
      loserPicture: fight.loserPicture,
    }
  })

  return {
    props: {
      fightHeroes,
      fightHistory,
    },
    revalidate: 60 * 60 * 8,
  };
};