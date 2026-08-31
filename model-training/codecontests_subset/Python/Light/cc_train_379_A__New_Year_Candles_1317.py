a,b = map(int,input().split())

total = 0
residual = 0

while a!=0:
    total+=a
    residual += a%b
    a = a//b
    if residual >= b:
        a += residual//b
        residual = residual%b

print(total)
