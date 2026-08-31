def solve(n, arr):
    seen, _min, _max = set(), float('inf'), float('-inf')
    for i in range(n):
        nxt = (i + arr[i % n]) % n
        if nxt in seen:
            return False
        seen.add(nxt)
        _min = min(_min, nxt)
        _max = max(_max, nxt)
    if _max - _min >= n:
        return False
    return True
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    if solve(n, arr):
        print('YES')
    else:
        print('NO')
