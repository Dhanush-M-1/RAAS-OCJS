a, b = map(int, input().split())
res = a
tob = a
while tob >= b:
    res += tob // b
    tob = tob // b + tob % b
print(res)