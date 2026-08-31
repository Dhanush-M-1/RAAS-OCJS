n = int(input())
for i in range(n):
    [l, r, d] = list(map(int, input().split(" ")))
    print(((r//d + 1)*d) if d >= l else d)
