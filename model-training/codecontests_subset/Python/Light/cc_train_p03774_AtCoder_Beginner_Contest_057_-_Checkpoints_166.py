N,M = list(map(int, input().split()))

s = []
for i in range(N):
    s.append(list(map(int, input().split())))

c = []
for j in range(M):
    c.append(list(map(int, input().split())))

for t1 in s:
    l = list(map(lambda x: abs(t1[0] - x[0]) + abs(t1[1] - x[1]), c))
    print(l.index(min(l)) + 1)
