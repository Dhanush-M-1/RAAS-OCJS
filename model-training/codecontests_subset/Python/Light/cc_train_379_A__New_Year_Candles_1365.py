a,b=map(int,input().split())
ncount=a
while a>=b:
    c=a%b
    a=a//b
    ncount+=a
    a=a+c
print(ncount)