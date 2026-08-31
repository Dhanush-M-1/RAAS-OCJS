for _ in range(int(input())):
    a = []
    for i in range(int(input())):
        a.append(input())
    if a[0][1] == "1" and a[1][0] == "1" and a[-1][-2] == "1" and a[-2][-1] == "1" or a[0][1] == "0" and a[1][0] == '0' and a[-1][-2] == "0" and a[-2][-1] == "0":
        print(2)
        print(1, 2)
        print(2, 1)
    elif a[0][1] == '0' and a[1][0] == '1' and a[-1][-2] == '1' and a[-2][-1] == '1' or a[0][1] == '1' and a[1][0] == '0' and a[-1][-2] == '0' and a[-2][-1] == '0':
        print(1)
        print(2, 1)
    elif a[0][1] == '1' and a[1][0] == '0' and a[-1][-2] == '1' and a[-2][-1] == '1' or a[0][1] == '0' and a[1][0] == '1' and a[-1][-2] == '0' and a[-2][-1] == '0':
        print(1)
        print(1, 2)
    elif a[0][1] == '1' and a[1][0] == '1' and a[-1][-2] == '0' and a[-2][-1] == '1' or a[0][1] == '0' and a[1][0] == '0' and a[-1][-2] == '1' and a[-2][-1] == '0':
        print(1)
        print(len(a) - 1, len(a))
    elif a[0][1] == '1' and a[1][0] == '1' and a[-1][-2] == '1' and a[-2][-1] == '0' or a[0][1] == '0' and a[1][0] == '0' and a[-1][-2] == '0' and a[-2][-1] == '1':
        print(1)
        print(len(a), len(a) - 1)
    elif a[0][1] == '0' and a[1][0] == '0' and a[-1][-2] == '1' and a[-2][-1] == '1' or a[0][1] == '1' and a[1][0] == '1' and a[-1][-2] == '0' and a[-2][-1] == '0':
        print(0)
    elif a[0][1] == '1' and a[1][0] == '0' and a[-1][-2] == '1' and a[-2][-1] == '0' or a[0][1] == '0' and a[1][0] == '1' and a[-1][-2] == '0' and a[-2][-1] == '1':
        print(2)
        print(1, 2)
        print(len(a) - 1, len(a))
    elif a[0][1] == '1' and a[1][0] == '0' and a[-1][-2] == '0' and a[-2][-1] == '1' or a[0][1] == '0' and a[1][0] == '1' and a[-1][-2] == '1' and a[-2][-1] == '0':
        print(2)
        print(1, 2)
        print(len(a), len(a) - 1)

