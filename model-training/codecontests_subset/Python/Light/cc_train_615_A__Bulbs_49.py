def new():
    x, y = map(int,input().split());lst = list()
    for p in range(x):
        a = list(map(int,input().split()))
        lst += a[1:]
    lst = list(set(lst))
    print("YES") if len(lst) == y else print("NO")
new()