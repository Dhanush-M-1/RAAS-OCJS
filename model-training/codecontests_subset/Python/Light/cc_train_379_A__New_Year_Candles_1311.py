n, x = map(int, input().split())
c = 0
s = 0
while(n > 0):
    c += n
    s += n%x
    n = n//x + s//x
    s = s%x
print(c)
