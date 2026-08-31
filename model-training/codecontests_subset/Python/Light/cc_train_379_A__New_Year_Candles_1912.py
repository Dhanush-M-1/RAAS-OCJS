a, b = map(int, input().split())
s = 0
n = 0
while a != 0:
    a -= 1
    s += 1
    if s==b:
        a+=1
        s = 0
    n += 1
print(n)