a, b = map(int, input().split()); ct = 0; i = 1
while a > 0:
    a -= 1; ct += 1
    if i % b == 0: a += 1
    i += 1
print(ct)
