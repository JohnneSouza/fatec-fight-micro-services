import format from 'date-fns/format';
import ptBR from 'date-fns/locale/pt-BR'

import styles from './styles.module.scss';

export function Header() {
    const currentDate = format(new Date(), 'EEEEEE, d MMM', {
        locale: ptBR,
    })
    return (
        <header className={styles.headerContainer}>
            <img src="https://media2.giphy.com/media/1vF0q2eTnvIr7GADQL/giphy.gif?cid=6c09b952kbuwzz6pk9klm8mg7ztwk1jew20eo9jn79bdgsao&rid=giphy.gif" alt="Fatec DevDay" />
            <p>FATEC - Arquitetura de Microserviços com Spring Boot</p>

            <span>{currentDate}</span>
        </header>
    );
}