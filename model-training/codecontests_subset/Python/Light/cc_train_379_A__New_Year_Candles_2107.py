n, m = map(int, input().split())

c = 0
while(n):
    c += 1
    n -= 1
    if c%m == 0:
        n += 1;

print(c)