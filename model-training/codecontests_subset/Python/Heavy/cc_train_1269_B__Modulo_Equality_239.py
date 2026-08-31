#import snoop
#from snoop import pp
#@snoop
def solve(a, b, n, m):
    a.sort()
    b.sort()
    res = m
    for i in range(n):
        delta = ((b[i] - a[0]) % m+ m) % m
        ok = True
        for j in range(n):
            #pp((j+i) % n, i)
            d = ((b[(j+i) % n] - a[j]) %m + m) % m
            if d != delta:
                ok =False
                break
        if ok == True:
           res = min(res,delta)
    return res 

(n, m) = [int(x) for x in input().split()]
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
print(solve(a,b,n,m))