"""
NTC here
"""
import sys
inp= sys.stdin.readline
input = lambda : inp().strip()
flush= sys.stdout.flush
# import threading
# setrecursionlimit(10**6)
# threading.stack_size(2**26)

def iin(): return int(input())
def lin(): return list(map(int, input().split()))

# range = xrange
# input = raw_input

def main():
    # from bisect import bisect_right as br
    T = iin()
    while T:
        T-=1
        n = iin()
        a = lin()
        def find(i):
            m1 = 0
            for j in range(n-1):
                x = i if a[j]==-1 else a[j]
                m1=max(m1, abs(x-(a[j+1] if a[j+1]!=-1 else i)))
            return m1
        l, r= 0, 10**9
        ans = [find(0), 0]
        while l<r:
            md = l+(r-l)//2
            x1, x2= find(md), find(md+1)
            #print(md, x1)
            if x1>x2:
                l = md+1
            else:
                r = md-1
            ans = min(ans, [x1, md], [x2, md+1])
        print(*ans)




             



















        
main()
#threading.Thread(target=main).start()