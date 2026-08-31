a, b = map(int, input().split())
res = 0
while True:
    if (a >= b):
        if (a%b != 0):
            res += a-(a%b)
            a = (a%b)+int(a/b)
        else:
            res += a
            a = a/b
    else:
        res += a
        break
print(int(res))
