a, b, c = [int(x) for x in input().split()]
if a == 0 and b == 0:
    if c == 0:
        print(-1)
    else:
        print(0)
elif a == 0:
    print(1)
    print("{0:.5f}".format(-c/b))
else:
    root1 = (-b+(b**2-4*a*c)**0.5)/(2*a)
    root2 = (-b-(b**2-4*a*c)**0.5)/(2*a)
    if root1 == root2:
        print(1)
        print("{0:.5f}".format(root1))
    elif type(root1) == complex and type(root2) == complex:
        print(0)
    elif type(root1) == complex:
        print(1)
        print("{0:.5f}".format(root2))
    elif type(root2) == complex:
        print(1)
        print("{0:.5f}".format(root1))
    elif root1 > root2:
        print(2)
        print("{0:.5f}".format(root2))
        print("{0:.5f}".format(root1))
    else:
        print(2)
        print("{0:.5f}".format(root1))
        print("{0:.5f}".format(root2))