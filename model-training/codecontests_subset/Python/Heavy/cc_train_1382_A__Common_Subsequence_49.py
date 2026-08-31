def search(a,k,lo,hi):
    while lo<=hi:
        mid = lo+(hi-lo)//2
        if a[mid] == k:
            return True
        elif a[mid]>k:
            hi = mid - 1
        else:
            lo = mid + 1
    return False
for _ in range(int(input())):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    b.sort()
    f = True
    for i in range(n):
        if search(b, a[i], 0, m-1):
            print("Yes")
            print(1, a[i])
            f = False
            break
    if f:
        print("No")