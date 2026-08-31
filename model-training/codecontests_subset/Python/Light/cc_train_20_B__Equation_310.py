a, b, c = map(int,input().split())
if a != 0:
    if b**2-4*a*c >= 0:
        root1 = (-b + (b**2-4*a*c)**0.5)/(2*a)
        root2 = (-b - (b**2-4*a*c)**0.5)/(2*a)
        list = [root1, root2]
        if root1 == root2:
            print(1)
            print(root1)
        else:
            print(2)
            print(min(list))
            print(max(list))
    else:
        print(0)
if a == 0 and b !=0:
    print(1)
    print(-c/b)
if a == 0 and b == 0:
    if c == 0:
        print(-1)
    elif c != 0:
        print(0)
