def main():
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = list(map(int, input().split()))
    a.sort()
    b.sort()
    c.sort()
    i = 0
    while i < n-1:
        if a[i] == b[i]:
            i += 1
        else:
            break
    print(a[i])
    i = 0
    while i < n-2:
        if b[i] == c[i]:
            i += 1
        else:
            break
    print(b[i])
if __name__ == '__main__':
    main()
