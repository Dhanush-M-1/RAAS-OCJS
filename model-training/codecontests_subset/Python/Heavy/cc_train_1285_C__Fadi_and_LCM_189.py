import sys
import math
def get(l,check,a,b,i,n):
    if i==n:
        check.append([a,b])
    else:
        get(l,check,a*l[i],b,i+1,n)
        get(l,check,a,b*l[i],i+1,n)
def get_primes(n):
    l=[]
    a=1
    while n%2==0:
        n=n//2
        a=a*2
    if a!=1:
        l.append(a)
    for i in range(3,int(math.sqrt(n))+2):
        a=1
        while n%i==0:
            n=n//i
            a=a*i
        if a!=1:
            l.append(a)
    if n>2:
        l.append(n)
    return l
n=int(sys.stdin.readline())
l=get_primes(n)
l.sort()
a,b=1,1
i=len(l)-1
while i>=0:
    if a>b:
        b=b*l[i]
        i-=1
    else:
        a=a*l[i]
        i-=1
#print(a,b)
#print(l)
check=[]
get(l,check,1,1,0,len(l))
a,b=check[0]
for i in range(1,len(check)):
    if abs(check[i][1]-check[i][0])<abs(a-b):
        a,b=check[i]
print(a,b)
