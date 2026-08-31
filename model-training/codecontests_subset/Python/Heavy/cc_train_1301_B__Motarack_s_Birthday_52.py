import sys
import bisect
from collections import deque
 
def no():
    print("NO")    
 
def dist(z, c):
    return (z[0] - c[0]) * (z[0] - c[0]) + (z[1] - c[1]) * (z[1] - c[1]);
 
def vec(z, c):
    return z[0] * c[1] - z[1] * c[0]
    
def pro(z,c):
    return [z[0] - c[0], z[1] - c[1]]
 
def main():
    # q = [int(i) for i in sys.stdin.readline().split()]
    n = int(sys.stdin.readline())
    q = [int(i) for i in sys.stdin.readline().split()]
    m = 0
    w = []
    ma = 0
    mi = 1e20
    for i in range(1, n):
        if q[i] != -1 and q[i - 1] != -1:
            m = max(abs(q[i]-q[i-1]), m)
        elif q[i] != -1 and q[i - 1] == -1:
            ma = max(q[i], ma)
            mi = min(q[i], mi)
        elif q[i] == -1 and q[i - 1] != -1:
            ma = max(q[i - 1], ma)
            mi = min(q[i - 1], mi)   
    if mi == 1e20:
        print(0, 1)
    else:
        print(max(m, (ma - mi + 1) // 2), ma - ((ma - mi + 1) // 2))
for i in range(int(sys.stdin.readline())):
    main()