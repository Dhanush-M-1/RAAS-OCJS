def binn(a,l,h,m):
    flag=True
    while (l<=h):
        mid=(l+h)//2
        if a[mid]==m:
            return mid
        if a[mid]>m:
            h=mid-1
        else:
            l=mid+1
    return -1

for t in range(int(input())):
    m,n=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    a.sort()
    b.sort()
    flag=True
    for x in a:
        if binn(b,0,len(b)-1,x)!=-1:
            print("YES\n1",x)
            flag=False
            break
    if flag:
        print("NO")