a,b=map(int, input().split())
k=a
while a>=b:
    m=a//b
    a%=b
    a+=m
    k+=m
print(k)
