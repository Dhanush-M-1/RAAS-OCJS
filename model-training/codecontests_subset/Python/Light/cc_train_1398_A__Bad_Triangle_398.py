t=int(input())
for i in range(t):
    n=int(input())
    lst=list(map(int,input().split()))
    m=max(lst)
    index=lst.index(m)
    flag=0
    lst.pop(index)
    for i in range(len(lst)-1):
        if(lst[i]+lst[i+1]<=m):
            print(i+1,i+2,index+1)
            flag=1
            break
    if(flag==0):
        print('-1')
    