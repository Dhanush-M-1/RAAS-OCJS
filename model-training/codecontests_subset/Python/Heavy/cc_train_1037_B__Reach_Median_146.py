def main():
    n, s = map(int, input().split())
    a = sorted(int(c) for c in input().split())

    i = n // 2
    median = a[i]
    

    if median == s:
        res = 0
    elif median < s:
        res = s - median
        i += 1
        while 1 <= i < n and a[i] < s:
            res += s - a[i]
            i += 1
    else:
        res = median - s
        i -= 1
        while 0 <= i < n - 1 and a[i] > s:
            res += a[i] - s
            i -= 1

    print(res)

    

if __name__ == '__main__':
    main()
