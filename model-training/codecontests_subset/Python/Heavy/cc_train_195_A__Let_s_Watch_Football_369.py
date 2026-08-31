def check(e, a, b, c):
    tot = a * c
    down = e * b
    if down + (c * b) >= tot:
        return 1
    else:
        return 0


def binary_search(arr, l, r, a, b, c):
    while l <= r:
        mid = l + (r - l) // 2
        if check(arr[mid], a, b, c):
            if mid != 0 and check(arr[mid - 1], a, b, c):
                r = mid - 1
            else:
                return arr[mid]
        else:
            l = mid + 1
    return -1


a, b, c = [int(i) for i in input().split()]
arr = [int(i) for i in range(a*c)]
x = binary_search(arr, 0, (a*c)-1,a,b,c)
print(x)