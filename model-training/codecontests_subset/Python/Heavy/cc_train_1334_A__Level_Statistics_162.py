t = int(input())
while t!=0:
    n = int(input())
    A = []
    B = []
    for k in range(n):
        p,q = map(int,input().split())
        A.append(p)
        B.append(q)
    i = 0
    tmp = 0
    if A != sorted(A) or B != sorted(B):
            tmp = 1
    if tmp != 1:
        while i < n:
            if B[i] > A[i]:
                tmp = 1
                break
            i+=1
    if tmp != 1:
        i = 0
        while i < n-1:
            if B[i+1]-B[i]>A[i+1]-A[i]:
                tmp = 1
            i+=1
    if tmp == 1:
        print('NO')
    else:
        print('YES')
    t-=1