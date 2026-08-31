n = int(input())
l = list(map(int, input().split()))
def find_gcd(x, y): 
    while(y): 
        x, y = y, x % y 
  
    return x 
      
lmax = max(l)
m = l.copy()
for i in range(len(m)):
	m[i] = lmax-m[i]
# print(m)
num1=m[0] 
num2=m[1] 
gcd=find_gcd(num1,num2) 
  
for i in range(2,len(m)): 
    gcd=find_gcd(gcd,m[i])

count = 0
for i in range(n):
	count+=m[i]//gcd

# if count == 0:
# 	print(0, 0)
# else:
# 	if gcd is 1 and len(l) is 2:
# 		print(gcd,count)
# 		# print(count)
# 	else:
# 		print(count,gcd)
# 		# print(gcd)
print(count,gcd)
