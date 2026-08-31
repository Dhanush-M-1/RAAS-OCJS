n,k=[int(i) for i in input().split()]
nd=0
r=0
while n>0:
    nd=nd+n
    
    m=(n+r)//k
    
    r=(n+r)-(k*m)
    n=m
    #print(n,r)
print(nd)
