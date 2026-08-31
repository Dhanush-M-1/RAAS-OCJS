m,n = map(int, input().split())
count = m

while(m>=n):
    temp = m//n + m%n
    count += m//n
    m = temp
 
print(count)
 				 			  	 	  				 			  		