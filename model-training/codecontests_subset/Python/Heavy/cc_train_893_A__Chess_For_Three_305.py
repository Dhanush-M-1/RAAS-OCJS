from sys import stdin,stdout
import bisect
# import collections
# import itertools
# import operator
# import functools
def ii():return int(stdin.readline())
def mi():return map(int,stdin.readline().split())
def li():return list(mi())
def si():return stdin.readline()


player = [True,True,False]
for i in range(ii()):
    a = ii()-1
    if not player[a]:
        print('NO')
        break
    for i in range(3):
        player[i] = not player[i]
    player[a] = not player[a]
else:
    print('YES')
    


    