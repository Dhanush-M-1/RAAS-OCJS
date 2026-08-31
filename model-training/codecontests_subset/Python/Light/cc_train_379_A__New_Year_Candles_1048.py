n, k = input().split()
n = int(n)
k = int(k)

count = n

while(n >= k):
    temp = n//k + n%k
    count += n//k
    n = temp

print(count)
	  			 		 	   		    	   	  			