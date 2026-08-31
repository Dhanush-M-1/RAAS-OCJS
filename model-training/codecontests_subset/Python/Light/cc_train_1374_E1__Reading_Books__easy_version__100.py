n,k = input().split(' ')
n,k = int(n), int(k)
S = []
for i in range(n):
    S.append(input().split(' '))
A = []
B = []
C = []
for i in S:
    if i[1] == '1' and i[2] == '1':
        C.append(int(i[0]))
    elif i[1] == '1' and i[2] == '0':
        A.append(int(i[0]))
    elif i[1] == '0' and i[2] == '1':
        B.append(int(i[0]))

m = min(len(A),len(B))

if len(C) + m < k:
    print(-1)
else:
    A.sort()
    B.sort()
    for i in range(m):
        C.append(A[i]+B[i])
    ans = 0
    C.sort()
    for i in range(k):
        ans+=C[i]
    print(ans)

