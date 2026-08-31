import sys
d = []
def bins(k, n):
    l = 0 
    r = n-2
    while l != r:
        mid = (l+r+1)//2
        if d[mid] <= k:
            l = mid
        else:
            r = mid-1
    # print("debug:", l)
    ex = k - d[l]
    if ex &1:
        f = ex//2
        return f + l + 2
    else:
        return l+1



for q in range(int(sys.stdin.readline())):
    n, l, r = [int(j) for j in sys.stdin.readline().split()]
    mx = n*(n-1)
    d = [0]*(n-1)
    for i in range(1, n-1):
        d[i] = d[i-1] + 2*(n-i)
    # print(d[-15:])
    ret = []
    # print("degug2:",bins(9998900028, n),bins(9998900029, n), bins(9998900030, n), bins(9998900031, n) )
    for i in range(l-1, r):
        ret.append(str(bins(0 if i == mx else i, n)))
    sys.stdout.write(" ".join(ret) + '\n')
    
