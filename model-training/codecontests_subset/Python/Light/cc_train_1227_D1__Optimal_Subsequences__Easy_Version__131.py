n = int(input())
b = list(map(int, input().split()))
a = []
for i in range(n):
    a.append([b[i], n - i])
a.sort()
a.reverse()
p = []
t = []
for i in range(n):
    t.append(a[i])
    d = t.copy()
    d.sort(key=lambda x: -x[1])
    p.append(d)
m = int(input())
#print(p)
for i in range(m):
    k, pos = map(int, input().split())
    d = p[k - 1].copy()
    #print(d)
    print(d[pos - 1][0])
    
