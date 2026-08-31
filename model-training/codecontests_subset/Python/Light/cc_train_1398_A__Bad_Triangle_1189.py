for t in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    l1=l.copy()
    l.sort()
    if l[0]+l[1]<=l[-1]:
        a=0
        if l[0]==l[1]:
            a+=1
        print(l1.index(l[0])+1,l1.index(l[1])+1+a,l1.index(l[-1])+1)
    else:
        print(-1)