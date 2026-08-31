for _ in range(int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=[]
    if(m<n):
        for i in b:
            if(i in a):
                c.append(i)
                break
    else:
        for i in a:
            if(i in b):
                c.append(i)
                break
    if(len(c)==0):
        print("NO")
    else:
        print("YES")
        print(len(c),end=" ")
        for i in c:
            print(i,end=" ")
        print()