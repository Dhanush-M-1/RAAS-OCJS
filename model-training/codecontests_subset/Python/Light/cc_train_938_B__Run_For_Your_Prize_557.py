n=int(input())
a=list(map(int,input().split()))
b=[i for i in a if i<=500000]
c=[i for i in a if i>500000]
if len(b)>0 and len(c)>0:
    z=max(b[-1]-1,1000000-c[0])
elif len(b)==0:
    z=1000000-c[0]
elif len(c)==0:
    z=b[-1]-1
print(z)