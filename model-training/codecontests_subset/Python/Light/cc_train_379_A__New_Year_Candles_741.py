a,b=map(int,input().split())
r=a
while a>a%b:
    r+=a//b
    a=a//b+a%b
print(r)