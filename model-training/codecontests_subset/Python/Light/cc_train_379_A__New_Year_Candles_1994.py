a,b=map(int,input().split())
h=a
while a>=b:
    h+=a//b
    r=a%b
    a=a//b+r
print(h)     
