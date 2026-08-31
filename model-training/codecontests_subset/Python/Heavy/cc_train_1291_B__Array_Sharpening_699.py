import sys
input = sys.stdin.readline


def main():
    t = int(input())
    for _ in range(t):
        N = int(input())
        A = [int(x) for x in input().split()]



        r1 = [False] * N
        r2 = [False] * N
        for i, a in enumerate(A):
            if a >= i:
                r1[i] = True
            else:
                break

        for i, a in enumerate(reversed(A)):
            if a >= i:
                r2[-i - 1] = True
            else:
                break

        f = False
        for i in range(N):
            if r1[i] and r2[i]:
                f = True
                break


        if f:
            print("Yes")
        else:
            print("No")






if __name__ == '__main__':
    main()


