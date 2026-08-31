for _ in range(int(input())):
    n=int(input())
    flag=0
    parr=[]
    carr=[]
    for i in range(n):
        p,c=map(int,input().split())
        parr.append(p)
        carr.append(c)
    for i in range(n):
        if parr[i]<carr[i]:
            flag=1
            break
    if flag==0:
        for i in range(1,n):
            if parr[i]<parr[i-1]:
                flag=1
                break
            if carr[i]<carr[i-1]:
                flag=1
                break
            if carr[i]-carr[i-1]>parr[i]-parr[i-1]:
                flag=1
                break
    print('YES' if flag==0 else 'NO')