for _ in range(int(input())):
    p1=[]
    c1=[]
    n=int(input())
    if(n==1):
        p,c=map(int,input().split())
        if(c>p):
            print("NO")
        else:
            print("YES")
        continue
    for i in range(n):
        p,c=map(int,input().split())
        p1.append(p)
        c1.append(c)
    flag=0
    for i in range(n-1):
        if(c1[i]>p1[i]):
            flag=1
            break
        d=p1[i+1]-p1[i]
        e=c1[i+1]-c1[i]
        if(d<0 or e<0):
            flag=1
            break
        elif(d==0 and e!=0):
            flag=1
            break
        elif(e>d):
            flag=1
            break
        else:
            continue
    if(flag==1):
        print("NO")
    else:
        print("YES")