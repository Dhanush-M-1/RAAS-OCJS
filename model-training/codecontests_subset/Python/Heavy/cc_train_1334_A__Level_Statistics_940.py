t = int(input())
e = []

for i in range(t):
    n = int(input())
    p0 = 0
    c0 = 0
    d = 'YES'

    for j in range(n): 
        p1, c1 = input().split(' ')
        p1 = int(p1)
        c1 = int(c1)

        #print((p1 >= c1), (p1 >  p0), (c1 > c0), (p1-p0 >= c1-c0))
        if (d == 'YES'):
            if (p1 >= c1) and (p1 >= p0) and (c1 >= c0) and (p1-p0 >= c1-c0):
                pass
            else:
                d = 'NO'

        p0 = p1
        c0 = c1

    e.append(d)

for i in e:
    print(i)