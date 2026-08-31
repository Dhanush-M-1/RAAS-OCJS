import sys

input = sys.stdin.readline

T = int(input())
for case in range(T):
    n = int(input())
    M = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        s = input()
        s = s[:len(s) - 1:]
        M[i] = s
    if M[1][0] != M[0][1] and M[n - 1][n - 2] != M[n - 2][n - 1]:
        if M[1][0] != M[n - 2][n - 1]:
            print(2)
            print(2, 1)
            print(n - 1, n)
        else:
            print(2)
            print(2, 1)
            print(n, n - 1)
    elif M[1][0] == M[0][1] and M[n - 1][n - 2] == M[n - 2][n - 1]:
        if M[1][0] == M[n - 1][n - 2]:
            print(2)
            print(n, n - 1)
            print(n - 1, n)
        else:
            print(0)
    elif M[1][0] == M[0][1] and M[n - 1][n - 2] != M[n - 2][n - 1]:
        if M[1][0] == M[n - 1][n - 2]:
            print(1)
            print(n, n - 1)
        else:
            print(1)
            print(n - 1, n)
    elif M[1][0] != M[0][1] and M[n - 1][n - 2] == M[n - 2][n - 1]:
        if M[1][0] == M[n - 1][n - 2]:
            print(1)
            print(2, 1)
        else:
            print(1)
            print(1, 2)