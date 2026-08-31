def main():
    n = int(input())
    a = list(sorted(map(int, input().split())))
    b = list(sorted(map(int, input().split())))
    c = list(sorted(map(int, input().split())))

    for i in range(n-1):
        if a[i] != b[i]:
            print(a[i])
            break
        if i == n-2:
            print(a[-1])
    for i in range(n-2):
        if b[i] != c[i]:
            print(b[i])
            break
        if i == n-3:
            print(b[-1])


main()