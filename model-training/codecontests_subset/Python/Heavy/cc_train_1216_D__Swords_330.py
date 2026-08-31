import math
n = int(input())
max = 0
a = []
inp = input().split()
j = 0
for i in inp:
    a.append(int(i))
    if a[j] > max:
        max = a[j] #estamos procurando x, 
    j += 1

same_type = 0
total_stolen = 0
for i in range(n):
    stolen = max - a[i] #quantas roubadas daquele tipo
    total_stolen += stolen
    same_type = math.gcd(same_type, stolen) #encontrar mdc
    #para saber maior numero de espadas do mesmo tipo
    #que podem ser roubadas por 1 pessoa, i.e., z

total_robbers = total_stolen/same_type #achamos y, menor numero de assaltantes

print(int(total_robbers), same_type)
	     		 	 					 			 	 	 			 	