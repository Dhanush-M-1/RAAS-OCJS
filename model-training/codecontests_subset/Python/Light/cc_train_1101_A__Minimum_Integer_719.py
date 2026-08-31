n = int(input())


def find(l, r, d):
    if d < l:
        return d
    return r + d - ((r + d) % d)


for _ in range(n):
    l, r, d = map(int, input().split())
    print(find(l, r, d))