import sys
input = sys.stdin.readline
from heapq import *

N,K,Q = map(int,input().split())
A = [int(x) for x in input().split()] # 大小逆にする。

# 通行止めを削除していって、区間をマージしていく
# 右端・左端が相互参照できるようにしておく
R_to_L = [None] * (N+10)
L_to_R = [None] * (N+10)
# 区間の左端に、残すK-1個のheapを入れる
rest = [[] for _ in range(N+10)]

from_max = sorted(enumerate(A), key = lambda x: x[1], reverse=True)

INF = 10 ** 18
get_reverse = [-INF] * Q

def push_K(arr,x):
    if len(arr) < K-1:
        heappush(arr,x)
    else:
        y = heappushpop(arr,x)
        # y が獲得できるようになる
        heappushpop(get_reverse, -y)

answer = INF
for i,x in from_max:
    left = R_to_L[i-1]
    right = L_to_R[i+1]
    # x 自身が採用できるか
    if left is None:
        left = i
        push_K(rest[left],x)
    else:
        push_K(rest[left],x)
    if right is None:
        right = i
    else:
        # merge
        for r in rest[i+1]:
            push_K(rest[left],r)
    R_to_L[right] = left
    L_to_R[left] = right
    score = -get_reverse[0] - x
    if answer > score:
        answer = score

print(answer)

