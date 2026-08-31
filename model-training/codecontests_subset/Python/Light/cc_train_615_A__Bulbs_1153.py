n,m = input().split()
n,m = int(n),int(m)
A = []
for i in range(0,n):
    a = input()
    b= 0
    for j in a.split():
        if b>0:
            A.append(int(j))
        b =1
A =list(set(A))
if len(A) == m:
    print('YES')
else:
    print('NO')