n, k = input().split(' ')
n = int(n)
k = int(k)

a = list(map(int, input().split(' ')))

a.sort( reverse = True)

for i in a:
    if(k % i == 0):
        print(int(k/i))
        exit()
	   			 		   	  	 		  	 		  		