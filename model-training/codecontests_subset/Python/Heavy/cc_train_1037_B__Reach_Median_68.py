def exe(arr, n, m):
    mid = int(n/2)
    s = 0
    if m > arr[mid]:
        while mid < n and arr[mid] < m:
            s = s + m - arr[mid]
            mid = mid + 1
        return s
    elif m < arr[mid]:
        while mid >= 0 and arr[mid] > m:
            s = s + arr[mid] - m
            mid = mid - 1
        return s
    else:
        return 0

def main():
    s = input().split(' ')
    n = int(s[0])
    m = int(s[1])
    arr = list(map(int, input().split(' ')))
    arr.sort()
    # print(arr)
    res = exe(arr,n,m)
    print(res)
main()
