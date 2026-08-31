n = int(input())
for i in range(n):
    l, r, d = map(int, input().split())
    x = d
    if x<l:
        print(x)
    if x>r:
        print(x)
    if x >= l and x <= r:
        k = r//x
        x = x * (k+1)
        print(x)
