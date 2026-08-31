a, b = map(int, input().split())
sum = a

while a >= b:
    ans = a % b
    a = a // b
    sum += a
    a += ans

print(sum)