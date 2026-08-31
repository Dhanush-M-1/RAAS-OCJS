a,b=map(int,input().split())
i=a
while a//b>0:
    i=i+a//b
    a=a//b+a%b
print(i)