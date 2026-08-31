inf = 1001

def merge(L, n1, R, n2):
    L.append(inf)
    R.append(inf)
    a = []
    i = j = 0
    while i < n1 or j < n2:
        if L[i] < R[j]:
            a.append(L[i])
            i += 1
        else:
            a.append(R[j])
            j += 1
    return a

def msort(a, n):
    if n == 1:
        return a
    else:
        n1 = n // 2
        n2 = n - n1
        L = a[:n1]
        R = a[n1:]
        L = msort(L, n1)
        R = msort(R, n2)
        return(merge(L, n1, R, n2))

a = list(map(int, input().split('+')))
n = len(a)

a = msort(a, n)

for x in range(n-1):
    print('{}+'.format(a[x]), end = '')
print(a[n-1])