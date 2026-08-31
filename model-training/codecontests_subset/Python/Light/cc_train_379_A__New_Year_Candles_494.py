a, b = [int(x) for x in input().split()]

used = 0
counter = 0
while a > 0 or used >= b:
    counter += 1
    a -= 1
    used += 1
    if used > b:
        used -= b
        a += 1

print(counter)
