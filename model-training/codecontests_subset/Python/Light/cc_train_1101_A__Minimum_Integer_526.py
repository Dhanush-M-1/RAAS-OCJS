def solve(l, r, d):
    if d < l:
        return d
    return d * ((r)//d+1)

q = int(input())
for i in range(q):
    l, r, d = map(int, input().split())
    print(solve(l, r, d))