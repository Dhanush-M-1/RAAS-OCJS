import sys

def read() : return sys.stdin.readline()

n, m = map(int, read().split())

p = [int(i) for i in read().split()]

gr = [0] * (n + 1)
for i in range(n + 1) :
    gr[i] = []

for i in range(m) :
    u, v = map(int, read().split())

    gr[u].append(v)

can = [0] * (n + 1)
can[p[n-1]] = 1

idx = n-2; good = 1; ans = 0;

while (idx >= 0) :
    cur = 0
    for i in gr[p[idx]] :
        cur += can[i]
    if (cur == good) :
        ans += 1
    else :
        good += 1
        can[p[idx]] = 1
    idx-=1

print(ans)