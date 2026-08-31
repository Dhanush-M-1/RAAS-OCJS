a, b = [int(i) for i in input().split()]
count = 0
used = 0
while True:
    if a == 0:
        break
    else:
        count += a
        used += a
        a = 0
        m = used // b
        a += m
        used -= m * b
print(count)