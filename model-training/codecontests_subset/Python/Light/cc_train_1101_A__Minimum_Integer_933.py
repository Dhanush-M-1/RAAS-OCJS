q = int(input())
for i in range(q):
    l, r, d = input().split()
    l, r, d = int(l), int(r), int(d)
    if l > d:
        x = d
    elif r < d:
        x = d
    else:
        x = (int(r/d)+1)*d
    print(x)