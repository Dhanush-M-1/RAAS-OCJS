t = int(input())
for i in range(t):
    n,m = map(int,input().split())
    s = input()
    A = list(map(int,input().split()))
    B = [0] * 26
    C = {}
    D = {}
    for i in range(m):
        if A[i] not in D:
            D[A[i]] = 0
        D[A[i]] += 1
    for i in range(n):
        B[ord(s[i]) - 97] += 1
        if (i + 1) in D:
            C[i + 1] = []
            for j in range(26):
                C[i + 1].append(B[j])
    for i in D:
        for j in range(26):
            B[j] += D[i] * C[i][j]
    print(*B)
    
        
        

    