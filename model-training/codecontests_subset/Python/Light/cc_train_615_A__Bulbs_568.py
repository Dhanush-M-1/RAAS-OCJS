n, m = map(int, input().split())
lm = [i for i in range(1, m + 1)]
for i in range(n):
    l = list(map(int, input().split()))[1:]
    for u in l:
        if u in lm:
            lm.pop(lm.index(u))
if len(lm) == 0:
    print("YES")
else:
    print("NO")