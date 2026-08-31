a,b = map(int,input().split())
r = 0
e = 0
while a > 0:
    r += a
    e += a
    a = e//b
    e = e%b
print(r)