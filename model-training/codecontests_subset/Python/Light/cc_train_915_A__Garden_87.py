if __name__ == '__main__':
    n, l = [int(i) for i in input().strip().split()]
    arr = [int(i) for i in input().strip().split()]
    mi = 10000000000000
    for i in arr:
        if l % i == 0:
            mi = min(mi, l // i)
    print(mi)
