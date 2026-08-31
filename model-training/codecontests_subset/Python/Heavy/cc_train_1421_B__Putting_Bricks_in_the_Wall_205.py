for test_var in range(int(input())):
    n = int(input())
    s = ['']*n
    for i in range(n):
        s[i] = input().strip()
    a, b, c, d = s[0][1], s[1][0], s[n-1][n-2], s[n-2][n-1]
    if a == b == c == d:
        print("2\n1 2\n2 1")
    elif a != b and c == d:
        if a == c:
            print("1\n1 2")
        else:
            print("1\n2 1")
    elif a == b and c != d:
        if a == c:
            print(f"1\n{n} {n-1}")
        else:
            print(f"1\n{n-1} {n}")
    elif a != b and c != d:
        if a == c:
            print(f"2\n1 2\n{n-1} {n}")
        else:
            print(f"2\n2 1\n{n-1} {n}")
    else:
        print(0)