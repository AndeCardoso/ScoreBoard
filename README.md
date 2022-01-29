Dado um arquivo(.csv), no formato abaixo, contendo o resultado de todos os jogos de futebol de um determinado campeonato:

time_1(mandante);time2(visitante);placar_time_1;placar_time_2;data_hora
Sao Paulo;Corinthians;5;0;2022-01-01 21:00:00
Sao Paulo;Palmeiras;3;2;2022-02-01 21:00:00
Sao Paulo;Santos;3;1;2022-02-03 21:00:00

Santos;Sao Caetano;1;1;2022-02-03 21:00:00
Santos;Sao Paulo;1;2;2022-02-04 21:00:00

Leia o arquivo em uma estrutura de dados, remova os registros duplicados(se houver), ordene por data/hora, time_1 e time_2. Subdivida a estrutura de dados por time (mandante) mantendo as ordens anteriores e gere um arquivo por time contendo o historico dos jogos ordenados por data. Gere um arquivo contendo a tabela de classificação final dos times, ordenado do que tiver mais pontos para o que tiver menos pontos (lembrando que: vitoria = 3pts, empate = 1pt, derrota = 0pt). Identificar a quantidade de vitorias, empates e derrotas de cada time. O arquivo com a tabela de classificação final deverá ser gerado no formato .csv, utilizando o separador ";", os demais poderão ser .txt.

Modelo arquivo por time:
01/01/22, 21h00: Sao Paulo 5 x 0 Corinthians
01/02/22, 21h00: Sao Paulo 3 x 2 Palmeiras
...

Modelo Arquivo resultado final
Time;Vitorias;Empates;Derrotas;Pontos
Sao Paulo;42;10;0;
Palmeiras;35;5;2;
Santos;30;5;7;
Corinthians;12;20;10;
...

Requisitos obrigatórios:
- o arquivo contendo a relação de jogos será fornecido pelo professor (registros desordenados e/ou duplicados)
- aplicar princípios de OO
- utilizar uma ferramenta de build/gerenciador de pacotes: Maven ou Gradle
- utilizar ao menos 2 dependências
- utilizar ao menos 2 estruturas de dados diferentes

Itens avaliados:
- ferramenta de build/gerenciador de pacotes
- uso de dependencias
- estrutura de dados
- ordenação
- manipulação de arquivos (leitura e escrita)
- fundamentos de OO