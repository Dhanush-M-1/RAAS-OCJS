for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    f1,f2 = -1,n
    # as sequence strictly increasing there must be an increase of one
    # so if at any index it drops below i value it means
    # we cannot make the sequence strictly increasing any further
    for i in range(n):
        if a[i]<i:
            break
        f1 = i
    for j in range(n-1,-1,-1):
        if a[j]<n-j-1:
            break
        f2 = j
    if f1>=f2:
        print('Yes')
    else:
        print('No')