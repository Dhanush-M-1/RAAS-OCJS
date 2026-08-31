t = int(input())
for ii in range(t):
    n = int(input())
    A = list(map(int,input().split()))
    B = []
    ab = 0
    for i in range(n-1):
        if A[i] == -1 and A[i+1] != -1:
            B.append(A[i+1])
        elif A[i] != -1 and A[i+1] == -1:
            B.append(A[i])
        else:
            ab = max(ab, abs(A[i] - A[i+1]))
    B.sort()
    # print(B)
    b = 0
    ab2 = 0
    
    if len(B) > 0:
        b = (B[-1] - B[0] + 1) // 2 + B[0]
        ab2 = max(abs(B[-1] - b), abs(B[0] - b))
    # print("ab",ab,ab2)
    print(max(ab, ab2), b)