import sys, math
sys.setrecursionlimit(10**6)
mod = 10**9 + 7
#mod = 998244353
input = lambda: sys.stdin.readline().rstrip()
def li(): return list(map(int, input().split()))

t = int(input())
for _ in range(t):
    input()
    K, N, M = li()
    A = li()
    B = li()
    adx = 0
    bdx = 0
    ans = []
    flag = False
    while adx+bdx <= N+M:
        if adx == N and bdx == M:
            break

        if adx < N:
            a = A[adx]
        else:
            a = 10**10
        if bdx < M:
            b = B[bdx]
        else:
            b = 10**10

        if a == 0:
            adx += 1
            K += 1
            ans.append(a)
            continue
        elif b == 0:
            bdx += 1
            K += 1
            ans.append(b)
            continue
        elif a <= K:
            adx += 1
            ans.append(a)
        elif b <= K:
            bdx += 1
            ans.append(b)
        else:
            print(-1)
            flag = True
            break
    if flag:
        continue
    print(*ans)

