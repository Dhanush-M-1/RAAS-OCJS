a,b = (int(s) for s in input().split())
sum = 0
while a >= b:
    sum += b
    a -= b - 1

print(sum + a)