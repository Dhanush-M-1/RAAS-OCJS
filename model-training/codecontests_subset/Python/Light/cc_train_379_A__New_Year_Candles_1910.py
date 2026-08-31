n, b = map(int,input().split())
c = 0
while n:
    n -= 1
    c += 1
    if c%b == 0:
        n += 1
print(c)