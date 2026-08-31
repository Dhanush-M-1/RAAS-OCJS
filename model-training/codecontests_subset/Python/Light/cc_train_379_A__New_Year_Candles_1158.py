a, b = map(int, input().split())
result = a
counter = 0
while a >= b:
    a -= b
    a += 1
    counter += 1
print(counter + result)
