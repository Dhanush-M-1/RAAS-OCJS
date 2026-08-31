def solve_m(a,k):
    l = 0
    r = 10**9
    for i in range(len(a)-1):
        if a[i]==-1 and a[i+1]!=-1:
            l = max(l,a[i+1]-k)
            r = min(r,a[i+1]+k)
        elif a[i+1]==-1 and a[i]!=-1:
            l = max(l,a[i]-k)
            r = min(r,a[i]+k)
    return -1 if l>r else l
def solve():
    n = int(input())
    a = list(map(int,input().split()))
    l = 0
    h = 10**9
    for i in range(n-1):
        if a[i]!=-1 and a[i+1]!=-1:
            l = max(l,abs(a[i]-a[i+1]))
    while l<h:
        mid = (l+h)//2 
        if solve_m(a,mid)!=-1:
            h = mid 
        else:
            l = mid+1
    print(l,solve_m(a,l))
t = int(input())
while t:
    t-=1
    solve()