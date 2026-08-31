for i in range(int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    a.sort()
    b.sort()
    i=0
    j=0
    lst=[]
    while i<n and j<m:
        if a[i]==b[j]:
            lst.append(str(a[i]))
            break
            i+=1
            j+=1
            
        elif a[i]>b[j]:
            j+=1
        else:
            i+=1
    if len(lst)>0:
        print('YES')
        print(1,end=" ")
        print(' '.join(lst))
    else:
        print('NO')