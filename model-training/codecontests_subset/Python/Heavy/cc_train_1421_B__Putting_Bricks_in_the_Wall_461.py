r = int(input())
for t in range(r):
    n = int(input())
    mas = [[x for x in input()] for i in range(n)]
    sright = mas[0][1]
    sbottom = mas[1][0]
    fleft = mas[-1][-2]
    ftop = mas[-2][-1]
    if sright == sbottom and fleft == ftop and sright != fleft:
        print(0)
    elif sright == sbottom:
        if fleft == ftop:
            print(2)
            print("1 2")
            print("2 1")
        elif fleft == sright:
            print(1)
            print(str(n) + " " + str(n - 1))
        elif ftop == sright:
            print(1)
            print(str(n - 1) + " " + str(n))
    elif fleft == ftop:
        if sright == fleft:
            print(1)
            print("1 2")
        elif sbottom == fleft:
            print(1)
            print("2 1")
    elif sright != ftop:
        print(2)
        print("1 2")
        print(str(n - 1) + " " + str(n))
    else:
        print(2)
        print("1 2")
        print(str(n) + " " + str(n - 1))


