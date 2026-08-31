q = int(input())
for i in range(q):
    x, y, z = map(int,input().split())

    if z > x and z > y:
        print(z)

    if (z > x and z < y) or (z == x) or (z == y):
        f = y//z
        m = (f+1)*z
        print(m)

    if z < x and z < y:
        print(z)
