# empiricalstudy
Availability of the artifacts generated in the development of the empirical study to evaluate the identification properties of infeasible testing requirements


The properties had been identified and marked through comments in the code.


(p1) Considerando atribuição de constante qualquer variável final ou qualquer atribuição de valor do tipo da variável. int a = 1; String a = "joao" A atribuição do contador do "for" pode causar não executabilidade?

(p2) identificação de instruções com predicados iguais ou opostos com sinalização de quais linhas se enquadram no p2 (neste caso sempre deve haver um casal de instruções)

(p3) a análise se baseia na ideia de que uma instrução pode influenciar diretamente outra região do código while(x>0) if(x > 3) a instrução do while dirá se a instrução if será utilizada - então depende diretamente correlação entre if alguma outra instrução que depende do resultado dele

(p4) Verificar se uma variável é alterada durante sua chamada - c uso (quando há alteração de valor durante a execução) Caso especial são loops v[i] é uma variável? pq eu não consigo controlar qual posição do vetor (somente em tempo de execução) será alterado logo não posso dizer que a variável foi alterada
