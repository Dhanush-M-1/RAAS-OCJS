def shortestSubsq(n,m,a,b):
    a=list(set(a))
    b=list(set(b))
    count={}
    a.extend(b)
    for i in a:
        count[i] = count.get(i,0) + 1
        if count[i]==2:
            print('YES')
            return print(1,i)
    return print('NO')
            

    # t=[[0]*(m+1) for i in range(n+1)]
    # for i in range(n+1):
    #     for j in range(m+1):
    #         if i==0 or j==0:
    #             t[i][j]=1
    # for i in range(1,n+1):
    #     for j in range(1,m+1):
    #         if a[i-1]==b[j-1]:
    #             t[i][j]+=1
    #         else:
    #             t[i][j]=max(t[i-1][j],t[i][j-1])
    # print(*t,sep='\n')
    # # print(t[n][m])
    
    # subsq=[]
    # i=n
    # j=m
    # while i>0 and j>0:
    #     if a[i-1]==b[j-1]:
    #         subsq.append(a[i-1])
    #     else:
    #         if t[i-1][j]>t[i][j-1]:
    #             i-=1
    #         elif t[i][j-1]>t[i-1][j]:
    #             j-=1
    #         else:
    #             if a[i-2]==b[j-1]:
    #                 subsq.append(a[i-2])
    #                 break

    # print(subsq)


t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    shortestSubsq(n,m,a,b)  