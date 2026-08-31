k = int(input())
for i in range(k):
    n = int(input())
    for j in range(1, n + 1):
        str = input()
        if j == 1:
            point_l1 = str[1]
        if j == 2:
            point_l2 = str[0]
        if j == n - 1:
            point_r1 = str[len(str) - 1]
        if j == n:
            point_r2 = str[len(str) - 2]

    if point_l1 == point_l2 and point_r1 == point_r2 and point_l1 != point_r1:
        print(0)
    elif  point_l1 == point_l2 and point_r1 == point_r2 and point_l1 == point_r1:
        print(2)
        print(1, 2)
        print(2, 1)
    elif  point_l1 != point_l2 and point_r1 != point_r2 and point_l1 == point_r1:
        print(2)
        print(1, 2)
        print(len(str), len(str) - 1)
    elif  point_l1 != point_l2 and point_r1 != point_r2 and point_l1 == point_r2:
        print(2)
        print(1, 2)
        print(len(str) - 1, len(str))
    elif point_l1 != point_l2 and point_l1 == point_r1 and point_r1 == point_r2:
        print(1)
        print(1, 2)
    elif point_l1 != point_l2 and point_l2 == point_r1 and point_r1 == point_r2:
        print(1)
        print(2, 1)
    elif point_r1 != point_r2 and point_l2 == point_r1 and point_l1 == point_l2:
        print(1)
        print(len(str) - 1, len(str))
    elif point_r1 != point_r2 and point_l2 == point_r2 and point_l1 == point_l2:
        print(1)
        print(len(str), len(str) - 1)

