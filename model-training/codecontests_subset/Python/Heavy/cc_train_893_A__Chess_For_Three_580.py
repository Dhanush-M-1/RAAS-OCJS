n = int(input())
c = [1, 2]
con = True
for i in range(n):
    p = int(input())
    if p not in c:
        con = False
        break
    else:
        if c == [1, 2] or c == [2,1]:
            d = c.index(p)
            if d == 0:
                c[-1] = 3
            else:
                c[0] = 3
        elif c == [1,3] or c == [3,1]:
            d = c.index(p)
            if d == 0:
                c[-1] = 2
            else:
                c[0] = 2
        elif c == [2,3] or c == [3,2]:
            d = c.index(p)
            if d == 0:
                c[-1] = 1
            else:
                c[0] = 1
if con:
    print("YES")
else:
    print("NO")
            

