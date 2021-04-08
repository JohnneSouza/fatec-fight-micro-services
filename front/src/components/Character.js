import React from 'react';

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
};

export default Character;