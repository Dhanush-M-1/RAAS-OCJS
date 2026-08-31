"""n, k = map(int, input().split())
carrots = list(map(int, input().split()))
sm = sum(carrots)
lst = []
ans = 0
for c in carrots:
    l = sm//k
    r = sm%k
    if c <= l:
        sm -=c
        k-=1
        lst.append(c)
last_in = len(lst)-1
for i in range(k):
    lst.append(l)
for i in range(last_in, r+last_in):
    lst[i] += 1
#print(lst)
for i in range(len(lst)):
    ans += lst[i]**2
print(ans)"""
# ////////////////////////////////////// A contest
""""
from queue import PriorityQueue
n, m = map(int, input().split())
room = []
room.append(0)
a = {}
unlock = 0
for i in range(n):
    start, end = map(int, input().split())
    a[start] = end + start
task = sorted(a.items(), key=lambda x: x[0])
task.insert(0, (0, 100000001))
# print(task)
for i in range(1, len(task)):
    # print("here")
    print(room)
    if room[0] <= task[i][0] <= room[0] + m:  # room available
        room.pop(0)
    else:
        unlock += 1
    room.append(task[i][1])
    room.sort()
print(n - unlock)
print(room)"""
# ///////////////////////////////////////////C emma getting serios
"""n = int(input())
names = []
ies = [0]*100001
repeated = []
f = False
for i in range(n):
    f = False
    name = input()
    ans = name
    if name in names:
        index = names.index(name)
        ans += str(ies[index]+1)
        ies[index] += 1
        f = True
    names.append(name)
    if f:
        print(ans)
    else:
        print("OK")"""

"""tc = int(input())
for i in range(tc):
    n = int(input())
    lst = list(map(int, input().split()))
    mx = max(lst)
    index = lst.index(mx)

    lst.append(0)
    if mx*n % sum(lst) == 0:
        print(-1)
    elif index == 0:
        while lst[index] == lst[index + 1]:
                    index += 1
    if lst[index] > lst[index+1]  or (index != 0 and lst[index] > lst [index-1]):
            print(index+1)"""
lst = list(map(int, input().split('+')))
lst.sort()
for i in range(len(lst)):
    if i == len(lst)-1:
        print(lst[i])
    else:
        print(str(lst[i])+'+', end="")


