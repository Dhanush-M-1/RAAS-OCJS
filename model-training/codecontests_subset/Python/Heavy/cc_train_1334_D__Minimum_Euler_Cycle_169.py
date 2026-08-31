from sys import stdin, gettrace
from math import sqrt

if not gettrace():
    def input():
        return next(stdin)[:-1]


# def input():
#    return stdin.buffer.readline()

def main():
    def solve():

        n,l,r = map(int, input().split())
        lv = int((2*n+1 - sqrt((2*n-1)**2 -4*(l-1)))/2)
        lvs = -2*n+2*n*lv-lv*lv+lv
        lrd = l - lvs - 1
        res = []
        i = lv
        j = lv+lrd//2 + 1
        if l%2 == 0:
            res = [j]
            if j < n:
                j+=1
            else:
                i+=1
                j = i+1
        for _ in range(l-1, r, 2):
            res += [i,j]
            if j < n:
                j += 1
            else:
                i +=1
                j = i+1
        if r == n*(n-1)+1:
            res[r-l] = 1
        print(*res[:r-l+1])



    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()