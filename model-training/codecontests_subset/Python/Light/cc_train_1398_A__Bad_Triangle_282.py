import io,os
from collections import deque
import bisect
from collections import deque
#input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
RL = lambda : list(map(int, input().split(' ')))
T = int(input())
for _ in range(T):
    n = int(input())
    l = RL()
    if l[0]+l[1]<=l[-1]:
        print(1,2,n)
    else:
        print(-1)