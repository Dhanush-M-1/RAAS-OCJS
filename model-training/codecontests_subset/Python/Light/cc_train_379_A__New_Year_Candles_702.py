a = list(map(int,input().strip().split()))
m = a[0]
n = a[1]
c = 0
while m >= n:
    c += m//n
    m = m//n + m%n
print(c+a[0])