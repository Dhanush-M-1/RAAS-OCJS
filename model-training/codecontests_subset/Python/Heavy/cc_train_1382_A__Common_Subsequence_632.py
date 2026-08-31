from sys import stdin, gettrace

if gettrace():
    inputi = input
else:
    def input():
        return next(stdin)[:-1]


    def inputi():
        return stdin.buffer.readline()


def solve():
    n,m = map(int, inputi().split())
    aa = {int(a) for a in inputi().split()}
    bb = {int(a) for a in inputi().split()}
    cc = aa & bb
    if cc:
        print("YES")
        print(1, cc.pop())
    else:
        print("NO")



def main():
    t = int(inputi())
    for _ in range(t):
        solve()


if __name__ == "__main__":
    main()