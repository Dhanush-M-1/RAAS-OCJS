t=int(input())
for _ in range(t):
    n = int(input())
    l=[]
    for i in range(n):
        l.append(input())
    x1,x2 = l[0][1], l[1][0]
    y1,y2 = l[-2][-1], l[-1][-2]
    x=[]
    if x1==x2:
        if y1!=str(1-int(x1)):
            x.append([n-1,n])
        if y2!=str(1-int(x1)):
            x.append([n,n-1])
    elif y1==y2:
        if x1!=str(1-int(y1)):
            x.append([1,2])
        if x2!=str(1-int(y1)):
            x.append([2,1])
    else:
        if x1!='1':
            x.append([1,2])
        else:
            x.append([2,1])
        if y1!='0':
            x.append([n-1,n])
        else:
            x.append([n,n-1])
    print(len(x))
    for i in x:
        print(*i)