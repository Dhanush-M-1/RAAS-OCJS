a,b=map(int,input().split())
k=a
ost=0
while a>=b:
    ost=a%b
    a=a//b
    k=k+a
    a=a+ost
print(k)