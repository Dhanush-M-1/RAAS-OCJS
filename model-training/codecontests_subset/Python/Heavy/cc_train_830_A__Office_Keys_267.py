import sys
import math
input = sys.stdin.readline
from functools import cmp_to_key;

def pi():
    return(int(input()))
def pl():
    return(int(input(), 16))
def ti():
    return(list(map(int,input().split())))
def ts():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))
mod = 1000000007;
f = [];
def fact(n,m):
    global f;
    f = [1 for i in range(n+1)];
    f[0] = 1;
    for i in range(1,n+1):
        f[i] = (f[i-1]*i)%m;

def fast_mod_exp(a,b,m):
    res = 1;
    while b > 0:
        if b & 1:
            res = (res*a)%m;
        a = (a*a)%m;
        b = b >> 1;
    return res;

def inverseMod(n,m):
    return fast_mod_exp(n,m-2,m);

def ncr(n,r,m):
    if n < 0 or r < 0 or r > n: return 0;
    if r == 0: return 1;
    return ((f[n]*inverseMod(f[n-r],m))%m*inverseMod(f[r],m))%m;

def main():
    AX();

def C():
    n = pi();
    a = ti();
    sm = [0 for i in range(n)];
    for i in range(n):
        if i == 0:
            sm[i] = a[i];
            continue;
        sm[i] = sm[i-1]+a[i];
    dp01 = [-1000000000 for i in range(n)];
    x = [[] for i in range(n)];
    for i in range(n):
        for j in range(i,-1,-1):
            #dp01[i] = max(dp01[i], sm[j-1]-(sm[i]-sm[j-1]) if j != 0 else sm[i]);
            if j != 0:
                if dp01[i] < sm[j-1]-(sm[i]-sm[j-1]):
                    dp01[i] = sm[j-1]-(sm[i]-sm[j-1]);
                    x[i] = [j-1,i+1];
            else:
                if dp01[i] < sm[i]:
                    dp01[i] = sm[i];
                    x[i] = [0,i+1];

    dp12 = [-1000000000 for i in range(n)];
    mx = -1000000000;
    mxIndex2 = 0;
    mxIndex1 = 0;
    for i in range(n):
        for j in range(i,-1,-1):
            #dp12[i] = max(dp12[i], dp01[j]+sm[i]-sm[j]-(sm[n-1]-sm[i]));
            if dp12[i] < dp01[j]+sm[i]-sm[j]-(sm[n-1]-sm[i]):
                dp12[i] = dp01[j]+sm[i]-sm[j]-(sm[n-1]-sm[i]);
                if dp12[i] > mx:
                    mx = dp12[i];
                    mxIndex2 = i+1;
                    mxIndex1 = j;
    ans = [x[mxIndex1][0], x[mxIndex1][1], mxIndex2];
    print('sum', sm);
    print(dp01);
    # print(mx);
    # print(*ans);


def A():
    [n,k,p] = ti();
    a = ti();
    b = ti();
    pre = [1000000000000000000 for i in range(k)];
    dp = [[1000000000000000000 for j in range(k)] for i in range(n)];
    for j in range(k):
        dp[0][j] = abs(a[0]-b[j])+abs(p-b[j]);
        pre[j] = min(pre[j-1],dp[0][j]) if j != 0 else dp[0][j];
    for i in range(1,n):
        curr = [1000000000000000000 for i in range(k)];
        for j in range(k):
            if j >= i:
                dp[i][j] = max(pre[j-1],abs(a[i]-b[j])+abs(p-b[j]));
                curr[j] = min(curr[j-1],dp[i][j]) if j != 0 else dp[i][j];
        pre = curr;

    ans = 1000000000000000000;
    for i in range(k):
        ans = min(ans,dp[n-1][i]);
    print(ans);

def AX():
    [n,k,p] = ti();
    a = sorted(ti());
    b = sorted(ti());
    ans = 100000000000000000;
    curr = 0;
    for i in range(k-n,-1,-1):
        curr = 0;
        for j in range(n):
            curr = max(curr,abs(b[i+j]-a[j])+abs(p-b[i+j]));
        ans = min(curr,ans);
    print(ans);


main();