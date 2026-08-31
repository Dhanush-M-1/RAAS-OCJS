for _ in range(int(input())):
    n=int(input())
    l=[]
    f=0
    for i in range(n):
        
        c=list(map(int,input().split()))
        if c[1]>c[0]:
            f=1
        if len(l)>0:
            if (c[0]==l[0][0] and c[1]>l[0][1]) or(c[0]<l[0][0] or c[1]<l[0][1]):
                f=1
            if c[0]>l[0][0] and c[1]>l[0][1]:
                if (c[0]-l[0][0])<(c[1]-l[0][1]):
                    f=1
            l.pop()
        l.append(c)
    if f==0:
        print("YES")
    else:
        print("NO")