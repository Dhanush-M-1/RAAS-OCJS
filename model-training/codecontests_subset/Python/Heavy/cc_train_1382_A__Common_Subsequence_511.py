def check(l,m):
    j=0
    i=0
    while(i<len(l) and j<len(m)):
        if(l[i]==m[j]):
            return l[i]
        elif(l[i]>m[j]):
            j=j+1
        else:
          i=i+1
    return -1

t=int(input())
for t1 in range(t):
    n,m=[int(x) for x in input().split()]
    l=[int(x) for x in input().split()]
    m=[int(x) for x in input().split()]
    l.sort()
    m.sort()
    a=check(l,m)
    if(a==-1):
        print("NO")
    else:
        print("YES")
        print("1",end=" ")
        print(a)
    