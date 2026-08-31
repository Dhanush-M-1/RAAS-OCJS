for _ in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        a=list(map(int,input().split()))
        l.append(a)
    p=0
    c=0
    flag=0
    for i in range(n):
        p1=l[i][0]
        c1=l[i][1]
        if p1<p or c1<c:
            flag=1 
            break
        elif p1>p:
            pd=p1-p
            cd=c1-c
            if cd>pd:
                flag=1 
                break
        elif p1==p:
            if c1!=c:
                flag=1
                break
        p=p1
        c=c1
    if flag==1:
        print("NO")
    else:
        print("YES")
            

        