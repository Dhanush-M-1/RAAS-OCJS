def ceil(a):
    if(a//1 == a):
        return int(a)
    else:
        return(int(a)+1)
for _ in range(0,int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    l = len(a)
    m = 0
    li = []
    for i in range(0,l-1):
        if(a[i]!=-1 and a[i+1]==-1):
            li.append(a[i])
        if(a[i+1]!=-1 and a[i]==-1):
            li.append(a[i+1])
        if(a[i+1]!=-1 and a[i]!=-1):
            if(abs(a[i+1]-a[i])>m):
                m= abs(a[i+1]-a[i])
    # print("m",m)
    li.sort()
    if(len(li)==0):
        print(0,0)
    else:
        # print(li)
        k = (+li[0]+li[-1])//2
        m = max(abs(k-li[0]),abs(k-li[-1]), m)
        print(m,k)