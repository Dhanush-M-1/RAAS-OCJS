a, b = [int(x) for x in input().split()]
cnt = a
new = 1
if a % b == 0:
    while new > 0:
        new = a // b
        cnt += a // b
        a = a // b + a % b
    print(cnt)
else:
    while new > 0:
        new = a // b
        cnt += a // b
        rem = a % b
        a = a//b + rem
    print(cnt)