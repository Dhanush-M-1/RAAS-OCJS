t=int(input())
for _ in range(t):
    n=int(input())
    if n==1:
        p, c = map(int, input().strip().split())
        if p>=c:
            print("YES")
        else:
            print("NO")
    else:

        l=[]
        k=[]
        flag=0
        for i in range(n):
            p,c=map(int,input().strip().split())
            if i==0:
                if p>=c:
                    l.append(p)
                    k.append(c)
                else:
                    flag=1
                    l.append(p)
                    k.append(c)
            else:
                if p>l[-1] and c>=k[-1] and p>=c and (p-l[-1])>=(c-k[-1]):
                    l.append(p)
                    k.append(c)
                elif p==l[-1] and c==k[-1]:
                    l.append(p)
                    k.append(c)
                else:
                    flag=1
                    l.append(p)
                    k.append(c)

        if flag==0:
            print("YES")
        else:
            print("NO")


