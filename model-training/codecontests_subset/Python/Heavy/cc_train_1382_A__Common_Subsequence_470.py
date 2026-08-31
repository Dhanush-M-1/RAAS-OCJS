import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n,m=map(int,input().split())
    L=list(map(int,input().split()))
    M=list(map(int,input().split()))
    flag = 0
    if n>m:
        for i in range(m):
            if M[i] in L:
                flag = 1
                val = M[i]
                break
    else:
        for i in range(n):
            if L[i] in M:
                flag = 1
                val = L[i]
                break
    if flag==0:
        print('NO')
    else:
        print('YES')
        print(1,val)
