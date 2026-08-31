while True:
    try:
        lst = list(map(float, input().split(',')))
        xa, ya = lst[0], lst[1]
        xb, yb = lst[2], lst[3]
        xc, yc = lst[4], lst[5]
        xd, yd = lst[6], lst[7]

        ans1 = ((yc - ya)*xb - (xc - xa)*yb + (xc * ya - xa * yc))
        ans2 = ((yc - ya)*xd - (xc - xa)*yd + (xc * ya - xa * yc))
        ans3 = ((yb - yd)*xa - (xb - xd)*ya + (xb * yd - xd * yb))
        ans4 = ((yb - yd)*xc - (xb - xd)*yc + (xb * yd - xd * yb))

        if ans1*ans2 > 0 or ans3*ans4 > 0:
            print("NO")

        else:
            print("YES")

    except EOFError:
        break
