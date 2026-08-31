def solve(N, cnt):
    if len(str(N)) == 1:
        return cnt
    sN = str(N)
    maxNum = 0
    for i in range(1, len(sN)):
        left = int(sN[0:i])
        right = int(sN[i:])
        maxNum = max(left * right, maxNum)
    ret = solve(maxNum, cnt + 1)
    return ret


Q = int(input())
for i in range(Q):
    N = int(input())
    ans = solve(N, 0)
    print(ans)

