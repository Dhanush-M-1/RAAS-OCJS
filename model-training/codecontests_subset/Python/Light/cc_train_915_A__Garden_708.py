n,k =[int(i) for i in input().split()] 
v = [int(z) for z in input().split()]
n = n-1
resposta = 0
v.sort()
for y in range(n, -1, -1):
  if(k%v[y] == 0):
    resposta = int(k/v[y])
    break
print(resposta)
  		  	  	   	  	     				 		 	