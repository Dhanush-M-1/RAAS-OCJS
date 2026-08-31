def main():
    n = int(input())
    s1, s2, e1, e2 = 0, 0, 0, 0
    for i in range(n):
        row = input()
        if i == 0:
            s1 = row[1]
        elif i == 1:
            s2 = row[0]
        if i + 2 == n:
            e1 = row[n-1]
        elif i + 1 == n:
            e2 = row[n-2]
    if s1 == s2:
        if e1 == e2:
            if e1 == s1:
                print(2)
                print("{} {}".format(1, 2))
                print("{} {}".format(2, 1))
            else:
                print(0)
        else:
            if e1 == s1:
                print(1)
                print("{} {}".format(n-1, n))
            else:
                print(1)
                print("{} {}".format(n, n-1))
    else:
        if e1 == e2:
            if s1 == e1:
                print(1)
                print("{} {}".format(1, 2))
            else:
                print(1)
                print("{} {}".format(2, 1))
        else:
            if s1 == e1:
                print(2)
                print("{} {}".format(1, 2))
                print("{} {}".format(n, n-1))
            elif s1 == e2:
                print(2)
                print("{} {}".format(1, 2))
                print("{} {}".format(n-1, n))





# # main()
for _ in range(int(input())):
    main()