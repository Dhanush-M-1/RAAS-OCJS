q = int(input())
ans = []
for i in range(q):
    l, r, d = map(int, input().split())
    if d < l or d > r:
        ans.append(d)
    else:
        ans.append(r - r % d + d)
for i in ans:
    print(i)