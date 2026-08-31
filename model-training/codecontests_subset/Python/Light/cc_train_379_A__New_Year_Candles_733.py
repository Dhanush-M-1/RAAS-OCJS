a,b = [int(x) for x in input().split()]
n = a
m = a
r = 0
p = 0
while m > b-1:
    r = m - int(m/b)*b
    p = int(m/b)
    m = p + r
    n = n + p
print(n)
