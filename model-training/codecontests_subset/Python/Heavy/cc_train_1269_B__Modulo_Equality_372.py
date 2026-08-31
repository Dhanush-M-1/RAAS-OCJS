import sys
input = sys.stdin.readline

n,m = map(int,input().split())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
s = set()
x = a[0]
for i in b:
    e = i-x
    if e >= 0:
        s.add(e)

    else:
        j = m+i
        s.add(j-x)

d = {}
for i in b:
    if i in d:
        d[i] = d[i] + 1

    else:
        d[i] = 1

for x in s:
    l = {}
    for i in a:
        u = (i + x) % m
        if u in l:
            l[u] = l[u] + 1

        else:
            l[u] = 1

    f = 0
    s = -1
    for u in l:
        if u in d:
            if d[u] != l[u]:
                f = 1
                break

        else:
            f = 1
            break

    if f == 0:
        s = x
        break

w = str(s)
sys.stdout.write(w)