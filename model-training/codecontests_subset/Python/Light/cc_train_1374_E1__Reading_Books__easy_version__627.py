t,k = map(int,input().split())
A = []
B = []
C = []
for i in range(t):
    a,b,c = map(int,input().split())
    if b == 1 and c == 0:
        A.append(a)
    elif b == 0 and c == 1:
        B.append(a)
    elif b == 1:
        C.append(a)
if min(len(A),len(B)) + len(C) < k:
    print(-1)
else:
    A.sort()
    B.sort()
    s = 0
    for i in range(min(len(A),len(B))):
        C.append(A[i] + B[i])
    C.sort()
    for i in range(k):
        s += C[i]
    print(s)