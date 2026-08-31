a, b = map(int, input().split())
total = 0
f = a
half = 0
while f > 0:
    total += f
    half += f
    f = half // b
    half %= b
print(total)