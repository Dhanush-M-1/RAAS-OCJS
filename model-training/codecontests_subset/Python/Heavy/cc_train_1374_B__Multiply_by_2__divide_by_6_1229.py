import math,collections 
  
# A function to print all prime factors of  
# a given number n 
def primeFactors(n): 
    f=[]
    # Print the number of two's that divide n 
    while n % 2 == 0: 
        f.append(2) 
        n = n / 2
          
    # n must be odd at this point 
    # so a skip of 2 ( i = i + 2) can be used 
    for i in range(3,4,2): 
          
        # while i divides n , print i ad divide n 
        while n % i== 0: 
            f.append(i) 
            n = n / i 
              
    # Condition if n is a prime 
    # number greater than 2 
    return f 
for _ in range(int(input())):
	n=int(input())
	if n==1:print(0)
	else:
		a=(primeFactors(n))
		d=collections.Counter(a)
		if 2 in d and 3 not in d:
			print(-1)
		elif 2 not in d and 3 in d:
			if 3**(d[3])!=n:
				print(-1)
			else:
				print(2*d[3])
		elif 2 in d and 3 in d:
			if d[2]>d[3]:
				print(-1)
			elif (2**(d[2]))*(3**(d[3]))!=n:
				print(-1)
			else:
				print(-d[2]+2*d[3]) 
		else:
			print(-1)
		# print(d)
		# #print(d)
		# k=sorted(list(d.keys()))
		# #print(k)
		# if len(k)==1:
		# 	if k!=[3]:
		# 		print(-1)
		# 	else: 
		# 		print(d[k[0]]*2)
		# elif len(k)==2:
		# 	if k!=[2,3]:
		# 		print(-1)
		# 	else: 
		# 		if d[2]>d[3]:
		# 			print(-1)
		# 		else:
		# 			cc=min(d[2],d[3])+(d[3]-d[2])*2
		# 			print(cc)

		# else:
		# 	print(-1)
		







