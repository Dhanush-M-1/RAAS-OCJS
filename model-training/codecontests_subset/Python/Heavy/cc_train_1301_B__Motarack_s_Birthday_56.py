from sys import stdin
#####################################################################
def iinput(): return int(stdin.readline())
def sinput(): return input()
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
#####################################################################

t = iinput()
while t:
    t-=1
    n = iinput()
    a = linput()
    missing = a.count(-1)
    if missing == n: print(0,0)
    else:
        mn, mx = 10**9, 0
        for i in range(n):
            if a[i] == -1:
                if i>0 and a[i-1]!=-1:
                    mn = min(mn, a[i-1])
                    mx = max(mx, a[i-1])
                if i<n-1 and a[i+1]!=-1:
                    mn = min(mn, a[i+1])
                    mx = max(mx, a[i+1])
        k = (mn+mx)//2
        mxd = 0
        for i in range(n):
            if a[i]==-1: a[i] = k
            if i>0:mxd = max(mxd, abs(a[i]-a[i-1]))
        print(mxd, k)