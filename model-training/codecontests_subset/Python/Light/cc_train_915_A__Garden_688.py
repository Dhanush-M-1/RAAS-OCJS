#182783
#Lucca Jordao

n, k = input().split()
n = int(n)
k = int(k)
baldes = []
baldes = input().split()
for i in range(n):
    baldes[i] = int(baldes[i])
maior = 0
for i in range(n):
    if baldes[i] > maior and k % baldes[i] == 0:
        maior = baldes[i]
if maior != 0:
    print(k//maior)
else:
    print(0)
	 			   			    	  	       			