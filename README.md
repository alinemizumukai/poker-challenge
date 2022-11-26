<h1>Desafio Poker</h1>
<h3>Programa Santander Coders 2022</h3>
<h5>Parceria da Let’s Code from Ada com o Santander Brasil.</h5>
<hr>
<h3>Trilha - Automação de Testes</h3>
<h5>Módulo I: Lógica de programação</h5>
<h5>Professor: Thalles Trevizan</h5>
<p style="text-align:justify">O objetivo do desafio foi desenvolver uma aplicação utilizando o conteúdo ensinado ao longo do módulo.</p>
<hr>
<h5>Instruções:</h5>
<p style="text-align:justify">Crie a classe Carta, que possui um nome e um naipe. Crie os métodos GET e SET para os atributos. 
Crie agora uma classe Baralho, que possui 52 cartas. No construtor de Baralho, inicialize as 52 cartas. 
Escreva os seguintes métodos: 
</p>
<ol type="a">
    <li>embaralhar( ) – usando o método Math.random dá para trocar as cartas dentro do baralho, misturando-as (sorteie duas posições e troque-as. Repita este processo diversas vezes).</li>
    <li>darCartas( ) – devolve duas cartas, retirada do topo do baralho, se não estiver vazio, ou null.</li>
    <li>temCarta( ) – verifica se tem carta no baralho, devolvendo true ou false. A classe Baralho, assim construída, será útil para programar diversos jogos de cartas, através de novas classes que os implementem.</li>
    <li>imprimeBaralho( ) – imprime as cartas para verificar como estão dispostas (se estão embaralhadas por exemplo).</li>
</ol>

<p>Funcionamento do programa:</p>
<ul>
    <li>No início do programa, pergunte quantos jogadores estão na mesa e retorne duas cartas aleatórias para cada jogador;</li>
    <li>Após isso, pergunte para cada jogador se ele quer abandonar a mão ou apostar e, se apostar, o quanto ele aposta. Repita esse processo até todos apostarem a mesma quantia;</li>
    <li>Toda vez que alguém abandonar, reimprimir as mãos dos jogadores restantes sem a mão do jogador que abandonou (o dinheiro que ele já tiver apostado deve continuar no montante);</li>
    <li>Assim que todos os jogadores tiverem apostado a mesma quantia, imprima mais 5 cartas e pergunte quem ganhou;</li>
    <li>Imprimir o número do jogador e quanto reais ele levou (soma de todas as apostas);</li>
    <li>Adicione um bloco Try/Catch para validar se o número de participantes é maior do que um. Se for igual ou menor, deve-se lançar uma Exception.</li>
</ul>