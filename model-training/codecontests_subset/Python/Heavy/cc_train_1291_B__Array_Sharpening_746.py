T = int(input())

for _ in range(T):
    n = int(input())
    A = [int(x) for x in input().split()]
    B = []
    C = []
    for i in range(n):
        if A[i] >= i:
            B.append(1)
        else:
            B.append(0)
        if A[i] >= n-i-1:
            C.append(1)
        else:
            C.append(0)
    firstdiffb = -1
    firstdiffc = -1
    for i in range(n-1):
        if B[i+1] != B[i]:
            firstdiffb = i+1
            break
    for i in range(n-1,0,-1):
        if C[i] != C[i-1]:
            firstdiffc = i
            break
    if firstdiffb == -1:
        if B[0] == 1:
            print('Yes')
        else:
            print('No')
    elif firstdiffc == -1:
        if C[-1] == 1:
            print('Yes')
        else:
            print('No')
    else:
        if B[0] == 0:
            print('No')
        elif C[-1] == 0:
            print('No')
        else:
                if firstdiffb > firstdiffc:
                    print('Yes')
                else:
                    print('No')