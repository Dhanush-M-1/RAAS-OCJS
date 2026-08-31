def sharpened(a):
    # ak> =k a1>=1 a2>=2 ..... ak-1>=k-1
    # an>=1 an-1>=2 ... ak+1 >= n-k ak>= n-k+1
    n = len(a)
    l = 0
    r = n-1
    for i in range(n):
        if a[i]>=i :
            l = i
            continue
        else:
            break
    for j in range(n-1, -1, -1):
        if a[j] >= n - j -1 :
            r = j
            continue
        else:
            break
    if l>=r:
        return 'Yes'
    return 'No'

t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(s) for s in input().split(' ')]
    print(sharpened(a))