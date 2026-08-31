a,b=map(int,input().split())
i=a
while a>=b:
    i+=a//b
    a=a//b+a%b
print(i)
