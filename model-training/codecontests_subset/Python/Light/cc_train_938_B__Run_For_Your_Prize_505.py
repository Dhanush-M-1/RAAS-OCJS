n = int(input())
a = [1] + list(map(int, input().split())) + [10**6]
p1,p2=1, 10**6
m = 10**7

for x in range(n+1):
    m = min(m, max(a[x] - 1,p2 - a[x+1]))
print(m)
