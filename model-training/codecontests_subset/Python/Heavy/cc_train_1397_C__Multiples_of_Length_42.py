import math


def main():
    n = int(input())
    lst = list(map(int, input().split()))
    line1 = "1 " + str(n) + '\n0 '
    line2 = "2 " + str(n) + '\n'
    line3 = "1 1\n" + str(-lst[0])
    for i in range(1, n):
        if lst[i] % (n - 1) != 0:
            line1 += str(-n * (lst[i] % (n - 1)))
            lst[i] -= (n * (lst[i] % (n - 1)))
        else:
            line1 += "0"
        line1 += " "
    for i in range(1, n):
        line2 += str(-lst[i]) + " "
    if n > 1:
        print(line1)
        print(line2)
    else:
        print("1 1\n0\n1 1\n0")
    print(line3)


if __name__ == '__main__':
    t = 1
    for i in range(t):
        main()
"""
60, 61
"""
"""
"""
