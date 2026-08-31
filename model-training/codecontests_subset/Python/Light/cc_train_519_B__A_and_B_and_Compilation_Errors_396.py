
n=int(input())

a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))

i=0
p,q,r=0,0,0
while(i<len(a)):
    p=p^a[i]
    i=i+1 
i=0
while(i<len(b)):
    q=q^b[i]
    i=i+1 
    
i=0
while(i<len(c)):
    r=r^c[i]
    i=i+1 
    
print(p^q)
print(q^r)