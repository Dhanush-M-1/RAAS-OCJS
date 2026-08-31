n=int(input())
x,z=0,1
a,b=map(int,input().split())
for i in range(n-1):
    c,d=map(int,input().split())
    if x==1:
        if a+b<c:
            z+=1
            a+=b
        x=0
    if x==0:
        if c-d>a:
            z+=1
        else:
            x=1
    a,b=c,d
if x==1:
    z+=1
print(z)   
