"""import sys,math
n=int(input())
mx=-1-sys.maxsize
val=[]
def meth1(i,k):
    return (i*k)//math.gcd(i,k)

def meth(i,j,k):
    
    return meth1(i,meth1(j,k))
for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            if meth(i,j,k)>mx:
                mx=meth(i,j,k)
                val=[i,j,k]

print(val)
print(mx)
"""

n=int(input())
if n==1:
    print(1)
elif n==2:
    print(2)
elif n%2==1:
    print(n*(n-1)*(n-2))
elif n%3==0:
    print((n-2)*(n-1)*(n-3))
else:
    print((n)*(n-1)*(n-3))
