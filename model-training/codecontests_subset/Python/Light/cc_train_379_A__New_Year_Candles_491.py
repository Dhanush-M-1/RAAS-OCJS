a, b = list(map(int, input().split()))

result = 0
while a >= b:
    result += b
    a -= b
    a += 1
print(result+a)
