import React, {useState, useEffect} from 'react';
import ReactDom from 'react-dom'

import './index.css';

const random_fighters_url = "https://fatec-hero-service.herokuapp.com/superhero"

const RetrieveUsers = () => {
  const [users, setUsers] = useState([])
  
  const getFighters = async () => {
    const response = await fetch(random_fighters_url);
    const users = await response.json()
    setUsers(users);
  };

  useEffect(() => {
    getFighters();
  }, []);

  return users;
};


function Character({id, name, powerstats, images}){
  return (
    <article className='character'>
      <img src={images} alt=""/>
      <h1>{name}</h1>
      <h4>Combat Power: {powerstats.combat}</h4>
      <h4>Durability: {powerstats.durability}</h4>
      <h4>{id}</h4>
    </article>
  )
}

function CharacterList(){
  return (
    <section className="characterList">
      {RetrieveUsers().map((char) => {
        return <Character key={char.id} images={char.images.md} name={char.name} powerstats={char.powerstats}/>
      })}
    </section>    
  )
}

ReactDom.render(
  <CharacterList/>,
  document.getElementById('root'))