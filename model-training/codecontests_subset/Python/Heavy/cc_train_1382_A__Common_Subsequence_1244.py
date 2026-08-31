def binarySearch(arr, l, r, x):
    while l <= r:

        mid = l + (r - l) // 2;

        # Check if x is present at mid
        if arr[mid] == x:
            return mid

            # If x is greater, ignore left half
        elif arr[mid] < x:
            l = mid + 1

        # If x is smaller, ignore right half
        else:
            r = mid - 1

    # If we reach here, then the element
    # was not present
    return -1

t = int(input())
for _ in range(t) :
    n,m = map(int,input().split())
    a = list(map(int, input().split()))
    b = list(map(int,input().split()))
    a.sort()
    b.sort()
    ans = -1
    for i in range(n) :
        temp = binarySearch(b,0,m-1,a[i])
        if temp != -1 :
            ans = a[i]
            break
    if ans != -1 :
        print('YES')
        print(f'1 {ans}')
    else :
        print('NO')