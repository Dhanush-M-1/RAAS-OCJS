def do_nach(a, n):
    k = -1
    for i in range(n):
        if a[i]>=i:
            pass
        else:
            k = i-1
            break
    return k

def is_ok(a, k, n):
    if n-k-2 >= a[k]:
        return False
    zn = n-k-2
    for i in range(k+1, n):
        if a[i]>=zn:
            pass
        else:
            return False
        zn-=1
    return True

t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    k = do_nach(a, n)
    if k == -1 or is_ok(a, k, n):
        print('Yes')
    else:
        print('No')
