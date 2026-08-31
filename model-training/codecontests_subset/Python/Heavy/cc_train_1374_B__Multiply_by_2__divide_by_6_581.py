from sys import stdin

input = stdin.readline


def main():
    test = int(input())

    for _ in range(test):
        n = int(input())
        # l = [int(i) for i in input().split(" ")]
        # x,y,n = [int(i) for i in input().split(" ")]
        # a,b,c,d = [int(i) for i in input().split(" ")]
        #
        # l = list(input().strip())
        # l = [int(i) for i in input().split(" ")]
        #
        # for i in l:
        #     print(i, end=' ')
        # print()
        m = n
        c = 0
        while n > 1:
            if n % 3 == 0:
                c += 1
                n = n // 3
            else:
                break

        ans = c
        while n > 1:
            if c == 0:
                break
            if n % 2 == 0:
                c -= 1
                n = n // 2
            else:
                break

        if n == 1:
            print(ans + c)
        else:
            print(-1)


main()
