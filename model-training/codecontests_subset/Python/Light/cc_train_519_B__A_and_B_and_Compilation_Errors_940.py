n = int(input())
erros = list(map(int, input().split()))
erros = sorted(erros)
comp_1 = list(map(int, input().split()))
comp_2 = list(map(int, input().split()))
comp_1 = sorted(comp_1)
comp_2 = sorted(comp_2)

for i in range(len(erros)-1,-1,-1):
    if(erros[i] != comp_1[i-1]): break
print(erros[i])

for e in range(len(comp_1)-1,-1,-1):
    if(comp_1[e] != comp_2[e-1]): break
print(comp_1[e])
		 		 			     	 	 	 	  			 	  	