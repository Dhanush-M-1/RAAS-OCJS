a, b = map(int,input().split())
c = 0
m = 0
while a != 0:
    c += a
    m += a
    a = m//b
    m = m % b
print(c)