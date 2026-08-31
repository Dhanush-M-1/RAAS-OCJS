a,b=tuple(map(int,input().split()))
s=a
x=a//b
while (a//b)!=0:
    s=s+x
    a=(a//b)+(a%b)
    x=a//b
print(s)
    
    