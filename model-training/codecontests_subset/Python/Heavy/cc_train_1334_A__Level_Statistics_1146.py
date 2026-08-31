t=int(input())
for q in range(t):
    n=int(input())
    plays=[]
    clears=[]
    for x in range(n):
        p,c=map(int,input().split())
        plays.append(p)
        clears.append(c)
    lastp=plays[0]
    lastc=clears[0]
    if lastp<lastc:
        print("NO")
        continue
    flag=True
    for x in range(1,n):
        if clears[x]>lastc and plays[x]<=lastp:
            flag=False
            break
        elif plays[x]<clears[x]:
            flag=False
            break
        elif plays[x]<lastp:
            flag=False
            break
        elif clears[x]<lastc:
            flag=False
            break
        elif clears[x]-lastc > plays[x]-lastp:
            flag=False
            break
        else:
            lastp=plays[x]
            lastc=clears[x]
    if flag:
        print("YES")
    else:
        print("NO")
