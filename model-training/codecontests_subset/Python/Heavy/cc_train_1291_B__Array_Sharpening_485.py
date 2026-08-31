#its so similar with 'A'
t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    limit=0
    if len(a)==1:
        print('Yes')
    else:
        for i in range(0,len(a)):
            elem=a[i]
            #print(0,elem,i,limit)
            if elem<limit:
                limit=a[i-1]-1
                break
            else:
                limit+=1
        else:
            print('Yes')
            continue
        for j in range(i,len(a)):
            if limit<0:
                print('No')
                break
            elem=a[j]
            #print(1,elem,j,limit)
            if elem<limit:
                limit=elem
            limit-=1
        else:
            print('Yes')
