for _ in range(int(input())):
    n = int(input())
    lis=list(map(int,input().split()))
    k=lis[0]
    lis[0]=0
    c=n
    for j in range(1,n):
        if lis[j]>=k:
            k-=1
        else:
            k=lis[j]
    if k>=0:
        print("Yes")
        continue 
    k=lis[0]           
    for i in range(1,n):
        if i<=lis[i]:
            k=i
        else:
            if lis[i]==lis[i-1]:
                k=lis[i]-1
            else:
                k=lis[i]    
            c=i
            break
#    print(c,k,'c')        
    for j in range(c+1,n):
#        print(k,lis[j])
        if lis[j]>=k:
            k-=1
        else:
            k=lis[j]
    if k<0:
        print("No")
    else:
        print("Yes")                        
