import React, {useState, useEffect} from 'react';
import Character from './components/Character'
import './App.css';

const fightServiceURL = "https://fatec-fight-frontend.herokuapp.com/fight"
const heroServiceURL = "https://fatec-hero-service.herokuapp.com/superhero"
const villainServiceURL = "https://fatec-villain-service.herokuapp.com/villain"

const RetrieveCharacter = () => {
  const [character, setUser] = useState([])
  
  const getFighter = async () => {
    const response = await fetch(heroServiceURL);
    const character = await response.json()
    setUser(character);
  };

  useEffect(() => {
    getFighter();
  }, []);

  return character;
};

function CharacterList(){
  return (
    <section className="characterList">
      {RetrieveCharacter().map((char) => {
        return <Character key={char.id} images={char.images.md} name={char.name} powerstats={char.powerstats}/>
      })}
    </section>    
  )
}

export default CharacterList;
