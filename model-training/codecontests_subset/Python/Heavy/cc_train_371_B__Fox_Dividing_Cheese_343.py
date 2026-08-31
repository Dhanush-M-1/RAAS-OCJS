import math

def solveTLE(n, m):
    if n == m: return 0
    dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

    for i in range(n+1):
        for j in range(m+1):
            if i == j:
                dp[i][j] = 0
                continue

            if i > j:
                op1, op2, op3 = math.inf, math.inf, math.inf

                if i %2 == 0: op1 = dp[i//2][j]

                if i%3 == 0: op2 = dp[i//3][j]

                if i%5 == 0: op3 = dp[i//5][j]

                res = min(op1, op2, op3)

                dp[i][j] = 1+ res

            else:
                op1, op2, op3 = math.inf, math.inf, math.inf

                if j %2 == 0: op1 = dp[i][j//2]

                if j%3 == 0: op2 = dp[i][j//3]

                if j%5 == 0: op3 = dp[i][j//5]

                res = min(op1, op2, op3)

                dp[i][j] = 1+ res
    
    res = dp[n][m]

    if res == math.inf: return -1

    return res


def solve(n, m):
    if n == m: return 0

    a2, b2, a3, b3, a5, b5 = 0, 0, 0, 0,0, 0

    while n%2 == 0:
        n = n//2
        a2+=1
    while m%2 == 0:
        m = m//2
        b2+=1
    
    while n%5 == 0:
        n = n//5
        a5+=1
    while m%5 == 0:
        m = m//5
        b5+=1


    while n%3 == 0:
        n = n//3
        a3+=1
    while m%3 == 0:
        m = m//3
        b3+=1
    

    if n!= m: return -1

    res = abs(a2-b2)+ abs(a3-b3)+ abs(a5-b5)

    return res

n, m = map(int, input().split())
print(solve(n, m))