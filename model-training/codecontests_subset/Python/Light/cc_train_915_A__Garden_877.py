n, k = input().split(" ")

n = int(n)
k = int(k)

lista = list(map(int, input().split(" ")))

lista.sort(reverse=True)

for x in lista:
    if (k%x) == 0:
        print(int(k/x))
        exit(0)
	 						 	  				 			       	  	