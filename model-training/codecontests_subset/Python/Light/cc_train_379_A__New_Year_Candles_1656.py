a,b=map(int,input().split())
k=a
ost=0
while a//b>0:
    k=k+a//b
    ost=a%b
    a=a//b+ost
print(k)        
