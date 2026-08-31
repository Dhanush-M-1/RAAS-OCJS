def process(A, B, k):
    answer = []
    i = 0
    j = 0
    n = len(A)
    m = len(B)
    curr = k
    while i < n or j < m:
        if i==n and B[j] <= curr:
            answer.append(B[j])
            if B[j]==0:
                curr+=1
            j+=1
        elif i==n:
            return [False, []]
        elif j==m and A[i] <= curr:
            answer.append(A[i])
            if A[i]==0:
                curr+=1
            i+=1
        elif j==m:
            return [False, []]
        elif A[i]==0:
            answer.append(A[i])
            curr+=1
            i+=1
        elif B[j]==0:
            answer.append(B[j])
            curr+=1
            j+=1
        elif A[i] <= curr:
            answer.append(A[i])
            i+=1
        elif B[j] <= curr:
            answer.append(B[j])
            j+=1
        else:
            return [False, []]
       # print(answer, curr)
    return [True, answer]

t = int(input())
for i in range(t):
    input()
    k, n, m = [int(x) for x in input().split()]
    A = [int(x) for x in input().split()]
    B = [int(x) for x in input().split()]
    a1, a2 = process(A, B, k)
    if a1:
        print(' '.join(map(str, a2)))
    else:
        print(-1)