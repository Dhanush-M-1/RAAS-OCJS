

"""
NTC here
"""
import sys
inp = sys.stdin.readline
def input(): return inp().strip()
flush= sys.stdout.flush
# import threading
# sys.setrecursionlimit(10**6)
# threading.stack_size(2**26)

def iin(): return int(input())


def lin(): return list(map(int, input().split()))

def lts(a, sep=''): return '{}'.format(sep).join(a)
out = []
# range = xrange
# input = raw_input


def main():
    T = iin()
    for _ in range(T):
        n = iin()
        p, c = 0, 0
        br = 0
        for lv in range(n):
            i, j = lin()
            if br:continue
            if i-p<0 or j-c<0 or i<j or (j-c)>(i-p):br = 1
            p, c = i, j
        out.append('YES' if br==0 else 'NO')


main()
print('\n'.join(out))
# threading.Thread(target=main).start()
