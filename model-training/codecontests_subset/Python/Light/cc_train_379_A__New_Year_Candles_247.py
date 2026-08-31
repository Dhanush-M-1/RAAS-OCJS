a, b = map(int, input().split())
tmp = 0
hours = 0
while (a >= 0):
    if tmp >= b:
        a += 1
        a -= 1
        hours += 1
        tmp -= b
        tmp += 1
    else:
        a -= 1
        hours += 1
        tmp += 1

print(hours-1)