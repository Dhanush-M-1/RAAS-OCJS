import math  

 
def printDivisors(n,l) : 
    i = 1
    while i <= math.sqrt(n): 
          
        if (n % i == 0) : 
            if (n / i == i) : 
                l.append(i) 
            else : 
                l.append(i)
                l.append(n//i)  
        i = i + 1
    return l
x = int(input())
lis = []
arr = printDivisors(x,lis)
maxi = 10000000000000000000000000000000000000000001

for i in arr:
	val = x//i
	if(math.gcd(i,val) == 1):
		if(max(i,val) < maxi):
			a = i
			b = val
			maxi = max(i,val)
print(int(a),int(b))