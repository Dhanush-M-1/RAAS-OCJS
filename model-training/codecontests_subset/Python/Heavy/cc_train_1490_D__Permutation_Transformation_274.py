
ans = []

def rec(l1,l2,par):
    global ans
    if(l1!=[]):
        mx1 = max(l1); 
        ans[mx1-1] = par+1
        idx1 = l1.index(mx1)
        rec(l1[0:idx1],l1[idx1+1::],par+1)
    if(l2!=[]):
        mx2 = max(l2); 
        ans[mx2-1] = par+1
        idx2 = l2.index(mx2)
        rec(l2[0:idx2],l2[idx2+1::],par+1)


for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    ans = [0 for i in range(n)]
    mx = max(a)
    ans[mx-1] = 0
    idx = a.index(mx)
    rec(a[0:idx],a[idx+1::],0)
    for i in a:
        print(ans[i-1],end=" ")
    print()

