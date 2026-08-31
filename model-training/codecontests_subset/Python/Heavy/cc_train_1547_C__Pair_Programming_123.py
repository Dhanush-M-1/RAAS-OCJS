def solve(k, A, B):
    n = len(A)
    m = len(B)
 
    i, j = 0, 0
    res = []
 
    for _ in range(n + m):
        if i < n and (A[i] == 0 or A[i] <= k):
            if A[i] == 0:
                k += 1
            res.append(A[i])
            i += 1
        elif j < m and (B[j] == 0 or B[j] <= k):
            if B[j] == 0:
                k += 1
            res.append(B[j])
            j += 1
        else:
            return [-1]
 
    return res
 
 
t = int(input())
 
for _ in range(t):
    _ = input()
 
    k, n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
 
    print(' '.join(str(x) for x in solve(k, A, B)))