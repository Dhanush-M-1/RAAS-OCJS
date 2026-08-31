t=int(input())
for _ in range(t):
    n,m=input().split()
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    g={}
    c=1000
    f=0
    for x in a:
        if x in b:
            print("YES")
            f=1
            print(1,end=' ')
            print(x) 
            break
    if f!=1:
        print("NO")
    # for x in a:
    #     if g.get(x):
    #         y=g.get(x)
    #     g.update({x:y+1})
    # if len(g)>0:    
    #     print("YES")
    #     for v in g:
    #         if g.get(v)==1:
    #             print(' ')
    #             print(int(v),end=' ')
    # else:
    #     print("NO")