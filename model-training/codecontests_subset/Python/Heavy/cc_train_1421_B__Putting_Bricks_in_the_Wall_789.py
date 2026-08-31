a = int(input())
for i in range (a):
    b = int(input())
    c = []
    d = 0
    for j in range (b):
        c.append(input())
    e = [int(c[0][1]), "1 2", int(c[1][0]), "2 1", int(c[-2][-1]), (str(b - 1) + " " + str(b)), int(c[-1][-2]), (str(b) + " " + str(b - 1))]
    f = e.count(0)
    if not f:
        print(2)
        print(e[1])
        print(e[3])
    elif f == 1:
        if e[0] != e[2]:
            if e[0]:
                print(1)
                print(e[1])
            else:
                print(1)
                print(e[3])
        else:
            if e[4]:
                print(1)
                print(e[5])
            else:
                print(1)
                print(e[7])
    elif f == 2:
        if e[0] == e[2]:
            print(0)
        else:
            print(2)
            print(e[1])
            if e[4] == e[2]:
                print(e[5])
            else:
                print(e[7])
    elif f == 3:
        if e[0] != e[2]:
            if not e[0]:
                print(1)
                print(e[1])
            else:
                print(1)
                print(e[3])
        else:
            if not e[4]:
                print(1)
                print(e[5])
            else:
                print(1)
                print(e[7])
    else:
        print(2)
        print(e[1])
        print(e[3])