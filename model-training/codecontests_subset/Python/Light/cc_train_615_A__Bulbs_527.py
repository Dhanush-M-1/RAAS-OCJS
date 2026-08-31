if __name__ == '__main__':
    n,m = map(int, input().split())
    a = list()
    for _ in range(n):
        b = list(map(int, input().split()))
        a += b[1:]
    a = set(a)
    if len(a) == m:
        print("YES")
    else:
        print("NO")
