a,b = map(int,input().split())
count = a
c = a
while c >= b:
    a = c // b
    count += a
    c %= b
    c += a
print(count)
