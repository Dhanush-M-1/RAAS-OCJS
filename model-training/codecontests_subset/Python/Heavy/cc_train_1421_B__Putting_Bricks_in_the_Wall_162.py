for _ in range(int(input())):
    n = int(input())
    a = []
    for i in range(n):
        x = input()
        s = [i for i in x]
        a.append(s)
    if a[0][1] == a[1][0]:
        if a[-1][-2] == a[-2][-1] == a[0][1]:
            print(2)
            print(n,n-1)
            print(n-1,n)
        elif a[0][1] == a[-1][-2]:
            print(1)
            print(n,n-1)
        elif a[1][0] == a[-2][-1]:
            print(1)
            print(n-1,n)
        else:
            print(0)
    elif a[-1][-2] == a[-2][-1]:
        if a[0][1] == a[1][0] == a[-1][-2]:
            print(2)
            print(1,2)
            print(2,1)
        elif a[0][1] == a[-1][-2]:
            print(1)
            print(1,2)
        elif a[1][0] == a[-1][-2]:
            print(1)
            print(2,1)
        else:
            print(0)
    else:
        print(2)
        if a[0][1] != a[-1][-2]:
            print(1,2)
            print(n,n-1)
        else:
            print(1,2)
            print(n-1,n)
            
            