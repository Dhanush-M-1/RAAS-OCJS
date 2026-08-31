"""
NTC here
"""
import sys
# reader = (s.rstrip() for s in sys.stdin)
# input = reader.__next__
inp = sys.stdin.readline


def input(): return inp().strip()


out = []
# flush = sys.stdout.flush
# import threading
# sys.setrecursionlimit(10**7)
# threading.stack_size(2**25)


def iin(): return int(input())


def lin(): return list(map(int, input().split()))


# range = xrange
# input = raw_input

def main():
    T = iin()
    while T:
        T-=1
        n = iin()
        a = lin()
        c1, c2 = 0, 0
        for i in range(n):
            if a[i]>=i:
                c1+=1
            else:break
        for i in range(n):
            if a[-i-1]>=i:
                c2+=1
            else:break
        # print(c1, c2)
        if c1+c2-1<n:print('NO')
        else:print('YES')
        #print(a1, a2)
main()
# threading.Thread(target=main).start()
