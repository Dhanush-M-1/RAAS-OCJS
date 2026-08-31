from sys import stdin,stdout
i1 = lambda : int(stdin.readline())
iia = lambda : map(int, stdin.readline().split())
isa = lambda: stdin.readline().split()

r1, r2 = iia()
c1, c2 = iia()
d1, d2 = iia()
if (c2 + r2 - d2) % 2 == 0:
    d = (c2 + r2 - d2) // 2
    c = r2 - d
    b = c2 - d
    a = r1 - b
    temp = [a, b, c, d]
    if len(set(temp)) != 4:
        print(-1)
    else:
        for i in temp:
            if not (i > 0 and i < 10):
                print(-1)
                break
        else:
            print(a, b)
            print(c, d)
else:
    print(-1)
    

