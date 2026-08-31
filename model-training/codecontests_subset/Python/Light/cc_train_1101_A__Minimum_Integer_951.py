def find(l, r, d):
    if l>d or r<d:
        return d
    return r + (d - r%d)


n = int(input())
for _ in range(n):
    l, r, d = map(int, input().split())
    print(find(l, r, d))