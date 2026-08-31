n, m = map(int, input().split())
ans = []
for i in range(n):
    inp = list(map(int, input().split()))
    ans.extend(inp[1:])
if m == len(set(ans)):
    print('YES')
else:
    print('NO')
