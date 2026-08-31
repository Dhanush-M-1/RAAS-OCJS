a,b = map(int,input().split())
sum = a
while a >= b:
    sum += a//b
    a = a//b + a % b
print(sum)