t=int(input())
for q in range(t):
    n,m=map(int, input().split())
    arr=list(map(int, input().split()))
    brr=list(map(int, input().split()))
    hasha=[0]*1001
    hashb=[0]*1001
    flag=0
    for i in range(n):
        hasha[arr[i]]+=1
    for i in range(m):
        hashb[brr[i]]+=1
    for i in range(1001):
        if hasha[i]>0 and hashb[i]>0:
            flag=1
            break
    if flag==1:
        print('YES')
        print(1,i)
    else:
        print('NO')





















