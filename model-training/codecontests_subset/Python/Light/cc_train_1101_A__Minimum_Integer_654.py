def minimal(a, b, c):
    if (c < a or c > b):
        return c
    else:
        return (b // c) * c + c


if __name__ == '__main__':
    q = int(input())
    for _ in range(q):
        l, r, d = map(int, input().split())
        print(minimal(l, r, d))
