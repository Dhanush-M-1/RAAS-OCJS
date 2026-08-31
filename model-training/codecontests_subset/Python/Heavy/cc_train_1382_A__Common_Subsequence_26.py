import io,os
from collections import deque
#input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
RL = lambda : list(map(int, input().split(' ')))

T = int(input())
for _ in range(T):
    n,m = RL()
    a = RL()
    b = RL()
    dic = [0]*(1001)
    for i in range(n):
        dic[a[i]] = 1
    flag = 0
    ans = 0
    for i in range(m):
        if dic[b[i]]==1:
            flag = 1
            ans = b[i]
            break
    if flag==0:
        print('NO')
    else:
        print('YES')
        print('1 %d'%ans)