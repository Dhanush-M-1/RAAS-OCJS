def calc(n,A):
    f=A[0]
    l=A[1]
    bool=False
    for i in range(2,n):
        if A[i]>=f+l:
            print(1,2,i+1)
            bool =True
            break
    if bool is False:
        print(-1)
for _ in range(int(input())):
    n=int(input())
    A=list(int(i)for i in input().split())
    calc(n,A)
