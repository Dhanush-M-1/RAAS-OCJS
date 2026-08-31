for i in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    p=max(l)
    i1=l.index(p)
    m1=min(l)
    i2=l.index(m1)
    l[i2]=p
    m2=min(l)
    i3=l.index(m2)
    if(m1+m2 <= p):
        i1+=1
        i2+=1
        i3+=1
        l1=[]
        l1.append(i1)
        l1.append(i2)
        l1.append(i3)
        l1.sort()
        print(*l1,sep=' ')
    else:
        print(-1)