a,b = map(int,input().split())
i = 1
out = 0
while a > 0:
    out += 1
    a -= 1
    if out == b:
        out = 0
        a += 1
    i += 1
print(i-1)