n = int(input())
for i in range(n):
    a,b= map(int,input().split())
    c= map(int,input().split())
    x = list(c)
    d =map(int,input().split())
    y=list(d)
    lis=[]
    if a<=b:
        for i in range(a):
            for j in range(b):
                if x[i]==y[j]:
                    lis.append(x[i])
                else:
                    pass  
        if len(lis)>0:
            print("YES")
            print("1", lis[0])
        else:
            print("NO")                  
    elif b<a:
        for i in range(b):
            for j in range(a):
                if y[i]==x[j]:
                    lis.append(y[i])
                else:
                    pass             
        if len(lis)>0:
           print("YES")
           print("1", lis[0])
        else:
           print("NO")                         