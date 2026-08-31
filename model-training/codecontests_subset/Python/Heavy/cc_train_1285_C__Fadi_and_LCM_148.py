def gcd(x, y): 
  
   while(y): 
       x, y = y, x % y 
  
   return x 

x=int(input())
f=[]
ans=(1000000000000,10000000000000000)
for i in range(1,int(x**(0.5))+1):
	if x%i==0:
		f.append(i)
		f.append(x//i)
		if gcd(i,x//i)==1:
			if max(i,x//i)<max(ans):
				ans=(i,x//i)
print (ans[0],ans[1])





# import math
# def primeFactors(n): 
# 	factors=[1]
# 	if n%2==0:
# 		factors.append(2)
# 	while n % 2 == 0:
# 		n = n // 2
# 	for i in range(3,int(math.sqrt(n))+1,2): 
# 		if n%i==0:
# 			factors.append(i)
# 		while n % i== 0: 
# 			n = n // i 
# 	if n > 2: 
# 		factors.append(n)
# 	return factors

# x=int(input())
# f=primeFactors(x)
# f.sort()
# print (f)
