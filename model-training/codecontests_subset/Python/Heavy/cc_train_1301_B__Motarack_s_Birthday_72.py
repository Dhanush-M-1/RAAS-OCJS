

t = int(input())
while t!=0:

    n = int(input())
    list1 = list(map(int,input().split()))

    u = []
    for i in range(len(list1)):
        if list1[i]!=-1:
            if (i>0 and list1[i-1]==-1)  or (i<n-1 and list1[i+1]== -1):
                u.append(list1[i])
    p,q=0,0
    if len(u)>0:
        p = max(u)
        q = min(u)
    else:
         p=0
         q=0





    ans = (p+q)//2
    maxi=0
    if list1[0]==-1:
        list1[0]=ans
    for i in range(1,len(list1)):
        if list1[i]==-1:
            list1[i]=ans
            maxi = max(maxi,abs(list1[i]-list1[i-1]))
        else:
            maxi = max(maxi,abs(list1[i]-list1[i-1]))
    print(maxi,ans)
    t-=1