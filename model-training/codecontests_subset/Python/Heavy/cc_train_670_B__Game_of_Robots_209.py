def triangular_numbers(N):
    triangulars = [0, 1]
    i = 2
    k = triangulars[-1]
    while (k < N):
        k += i
        triangulars.append(k)
        i += 1
        k = triangulars[-1]
    return triangulars


def binary_search(arr, item):
    low, high = 0, len(arr)
    while high > low + 1:
        mid = (low + high) // 2
        if arr[mid] == item:
            return mid
        elif arr[mid] > item:
            high = mid
        elif arr[mid] < item:
            low = mid

    return low


def kth_identifier(n, k, items):
    tris = triangular_numbers(3000000000)
    ix = binary_search(tris, k)
    if tris[ix] > k:
        while tris[ix] > k:
            ix -= 1
    if tris[ix] == k:
        return items[ix - 1]
    if tris[ix] < k:
        kth = k - tris[ix]
        return items[kth - 1]


def main():
    n, k = [int(i) for i in input().strip().split()]
    items = [int(i) for i in input().strip().split()]
    ans = kth_identifier(n, k, items)
    print(ans)


if __name__ == '__main__':
    main()
