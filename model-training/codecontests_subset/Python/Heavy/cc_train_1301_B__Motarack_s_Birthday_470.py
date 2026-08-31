from math import ceil
for _ in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    m=[max(l),-1]
    mini=-1
    if all(i==-1 for i in l):
        print(0,0)
        continue
    for i in range(n-1):
        if l[i+1]==-1 and l[i]!=-1:
            m[:] = [min(l[i],m[0]),max(l[i],m[1])]
        elif l[i]==-1 and l[i+1]!=-1:
            m[:] = [min(l[i+1], m[0]), max(l[i+1], m[1])]
        else:
            mini = max(abs(l[i+1]-l[i]),mini)
    mini = max(mini,ceil((m[1]-m[0])/2))
    print(mini, (m[1]+m[0])//2)