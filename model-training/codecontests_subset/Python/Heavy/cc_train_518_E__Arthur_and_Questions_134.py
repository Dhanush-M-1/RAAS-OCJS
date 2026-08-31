INF = 1 << 60
Q = 1 << 58

def solve():
    ans = [0] * n
    for i in range(k):
        b = [-INF]
        b.extend(a[i:n:k])
        m = len(b)
        b.append(INF)
        lb = -INF
        p, q = 1, 0
        while p < m:
            while b[p] == Q:
                p += 1
            l = p - q - 1
            lb = b[q] + 1
            for j in range(q + 1, p):
                b[j] = lb
                lb += 1
            if b[p] < lb:
                return None
            if lb < 0:
                if b[p] > 0:
                    lb = min((l - 1) // 2, b[p] - 1)
                elif b[p] <= 0:
                    lb = b[p] - 1
                for j in range(p - 1, q, -1):
                    b[j] = lb
                    lb -= 1
            q = p
            p = q + 1
        ans[i:n:k] = b[1:m]
    return ans


n, k = [int(x) for x in input().split()]
a = [Q if x == '?' else int(x) for x in input().split()]
ans = solve()
if ans is None:
    print('Incorrect sequence')
else:
    print(*ans)
