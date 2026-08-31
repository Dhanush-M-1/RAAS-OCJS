def func():
    n = int(input())
    s = 0
    e = 0
    pcl = []
    for _ in range(n):
        p, c = map(int, input().split())
        pcl.append((p,c))
    for p,c in pcl:
        if p < c:
            print("NO")
            return
        if p - s < c - e:
            print("NO")
            return
        if s > p:
            print("NO")
            return
        if e > c:
            print("NO")
            return
        s = p
        e = c

    print("YES")
    return


t = int(input())
for _ in range(t):
    func()
