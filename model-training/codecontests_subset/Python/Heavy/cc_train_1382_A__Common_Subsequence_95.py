t=int(input())
while t>0:
    n,m=map(int,input().split())
    l=[int(x) for x in input().split()]
    m1=[int(y) for y in input().split()]
    c=0
    if(n>=m):
        for i in range(m):
            if(m1[i] in l):
                print("YES")
                print(1,m1[i])
                c+=1
                break
        if(c==1):
            pass
        else:
            print("NO")
    else:
        for i in range(n):
            if(l[i] in m1):
                print("YES")
                print(1,l[i])
                c+=1
                break
        if(c==1):
            pass
        else:
            print("NO")
    t-=1
            
