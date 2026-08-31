#182783
#Lucca Jordao

n = int(input())
erros = []
dic = {}
dic_1 = {}
dic_2 = {}
erros_1 = []
erros_2 = []
remove = -1

erros = input().split()

for i in range(n):
    erros[i] = int(erros[i])
    if erros[i] not in dic:
        dic[erros[i]] = 1
    else:
        dic[erros[i]] += 1

erros_1 = input().split()

for i in range(n-1):
    erros_1[i] = int(erros_1[i])
    if erros_1[i] not in dic_1:
        dic_1[erros_1[i]] = 1
    else:
        dic_1[erros_1[i]] += 1

erros_2 = input().split()

for i in range(n-2):
    erros_2[i] = int(erros_2[i])
    if erros_2[i] not in dic_2:
        dic_2[erros_2[i]] = 1
    else:
        dic_2[erros_2[i]] += 1


for key in dic:
    if key in dic_1:
        if dic_1[key] < dic[key]:
            print(key)
    else: 
        print(key)

for key in dic_1:    
    if key in dic_2:
        if dic_1[key] > dic_2[key]:
            print(key)
    else: 
        print(key)
    



 	   		 	      	    			  	  	 	