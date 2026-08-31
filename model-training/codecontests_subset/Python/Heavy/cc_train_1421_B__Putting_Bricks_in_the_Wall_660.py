for u in range(int(input())):
    n=int(input())
    l=[]
    x,y=[],[]
    for i in range(n):
        l.append(list(input()))
    d=[l[0][1],l[1][0],l[n-1][n-2],l[n-2][n-1]]
    if(d[0]=='1'):
        x.append([1,2])
    if(d[1]=='1'):
        x.append([2,1])
    if(d[2]=='0'):
        x.append([n,n-1])
    if(d[3]=='0'):
        x.append([n-1,n])
    if(d[0]=='0'):
        y.append([1,2])
    if(d[1]=='0'):
        y.append([2,1])
    if(d[2]=='1'):
        y.append([n,n-1])
    if(d[3]=='1'):
        y.append([n-1,n])
    if(len(x)<=len(y)):
        print(len(x))
        for i in x:
            print(*i)
    else:
        print(len(y))
        for i in y:
            print(*i)
