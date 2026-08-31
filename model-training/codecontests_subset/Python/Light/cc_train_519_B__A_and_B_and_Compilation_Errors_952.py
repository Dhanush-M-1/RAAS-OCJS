num_de_relatorios = int(input())
relatorio_um = list(map(int,input().split()))
relatorio_dois = list(map(int,input().split()))
relatorio_tres = list(map(int,input().split()))

print(sum(relatorio_um) - sum(relatorio_dois))
print(sum(relatorio_dois) - sum(relatorio_tres))
  			   	 			    		  	     				