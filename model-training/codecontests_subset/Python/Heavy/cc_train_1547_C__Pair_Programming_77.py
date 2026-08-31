def Pairs(A, B):
    i, j = 0, 0
    curr = k
    ans = []
    while i < len(A) and j < len(B):
        if A[i] <= B[j]:
            if A[i] == 0:
                curr += 1
            elif curr < A[i]:
                print(-1)
                return
            ans.append(A[i])
            i += 1
        else:
            if B[j] == 0:
                curr += 1
            elif curr < B[j]:
                print(-1)
                return
            ans.append(B[j])
            j += 1
    if i == len(A):
        while j < len(B):
            if B[j] == 0:
                curr += 1
            elif curr < B[j]:
                print(-1)
                return
            ans.append(B[j])
            j += 1
    else:
        while i < len(A):
            if A[i] == 0:
                curr += 1
            elif curr < A[i]:
                print(-1)
                return
            ans.append(A[i])
            i += 1
    print(*ans)


t = int(input())
for _ in range(t):
    s = input()
    k, n, m = map(int, input().split())
    # (index, ai/bi)
    A = [int(x) for x in input().split()]
    B = [int(x) for x in input().split()]
    Pairs(A, B)