def cumsum(x):
    n = len(x)
    ans = [0]*(n+1)
    for i in range(n):
        ans[i+1]=ans[i]+x[i]
    return ans

def solve(k, t, a, b):
    n = len(t)
    b10, b01, b11=[],[],[]
    for i in range(n):
        if (a[i]==1 and b[i]==1):
            b11.append(t[i])
        elif a[i]==1:
            b10.append(t[i])
        elif b[i]==1:
            b01.append(t[i])
    
    b10=sorted(b10)
    b01=sorted(b01)
    b11=sorted(b11)
    
    b1 = [b10[i] + b01[i] for i in range(min(len(b10), len(b01)))]
    
    cs_b1 = cumsum(b1)
    cs_b11 = cumsum(b11)
    
    
    if len(b1) + len(b11) < k:
        return -1
    
    ans=1e100
    for i in range(0, k+1):
        if i<=len(b1) and k-i<=len(b11):
            ans = min(ans, cs_b1[i] + cs_b11[k-i])
    return ans
    
n, k = map(int, input().split())
a,b,t = [0]*n,[0]*n,[0]*n
for i in range(n):
    t[i], a[i], b[i] = map(int, input().split())
print(solve(k, t,a,b))