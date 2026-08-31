import sys
#input=sys.stdin.readline

T=int(input())
for _ in range(T):
    n=int(input())
    A=[]
    for i in range(n):
        A.append(input())

    a1,b1=int(A[0][1]),int(A[1][0])
    a2,b2=int(A[n-1][n-2]),int(A[n-2][n-1])

    
    if(a1==b1):
        c=0
        ans=[]
        if (a2==a1):
            c=c+1
            ans.append([n,n-1])

        if (b2==a1):
            c=c+1
            ans.append([n-1,n])

        print(c)
        for i in ans:
            print(*i)

    elif(a2==b2):
        c=0
        ans=[]
        if (a2==a1):
            c=c+1
            ans.append([1,2])

        if (b2==b1):
            c=c+1
            ans.append([2,1])

        print(c)
        for i in ans:
            print(*i)

    else:
        #print(a1,b1,a2,b2)
        c=0
        ans=[]
        if (a1==1):
            c=c+1
            ans.append([1,2])
        if (b1==1):
            
            c=c+1
            ans.append([2,1])
        if (a2==0):
            c=c+1
            ans.append([n,n-1])
        if (b2==0):
            c=c+1
            ans.append([n-1,n])
        print(c)
        for i in ans:
            print(*i)
