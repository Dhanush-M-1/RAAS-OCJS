a, b = list(map(int, input().split()))
total = a
while True:
    x = a % b
    a = a // b
    if a == 0:
        break
    total += a
    a += x
print(total)