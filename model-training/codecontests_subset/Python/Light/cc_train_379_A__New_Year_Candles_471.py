a, b = map(int, input().split())
k = a
while a >= b:
    os = a % b
    a //= b
    k += a
    a += os
print(k)