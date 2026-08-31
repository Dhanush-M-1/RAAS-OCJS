"""
https://codeforces.com/contest/1421/problem/B
"""

for _ in range(int(input())):
    n = int(input())

    array = []
    for _ in range(n):
        array.append(list(input()))

    important = []
    important.append(int(array[0][1]))
    important.append(int(array[1][0]))
    important.append(int(array[n-2][n-1]))
    important.append(int(array[n-1][n-2]))

    count = important.count(0)

    if count == 0 or count == 4:
        print("2")
        print("1 2")
        print("2 1")

    elif count == 2:
        if important[0] == important[1]:
            print("0")
        else:
            print("2")
            if important[0] == 0:
                print("2 1")
            else:
                print("1 2")

            if important[2] == 1:
                print(str(n) + " " + str(n-1))
            else:
                print(str(n-1) + " " + str(n))

    elif count == 3:
        x = important.index(1)
        print("1")
        if x == 0:
            print("2 1")
        elif x == 1:
            print("1 2")
        elif x == 2:
            print(str(n) + " " + str(n-1))
        else:
            print(str(n-1) + " " + str(n))

    elif count == 1:
        x = important.index(0)
        print("1")
        if x == 0:
            print("2 1")
        elif x == 1:
            print("1 2")
        elif x == 2:
            print(str(n) + " " + str(n-1))
        else:
            print(str(n-1) + " " + str(n))