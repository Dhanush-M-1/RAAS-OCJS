import heapq

n,m = list(map(int, list(input().split())))
list = list(map(int, input().split()))
more = []
less = []
amount_mid = 0
amount_more = 0
amount_less = 0

for el in list:
    if(el > m):
        amount_more += 1
        more.append(el - m)
    elif(el < m):
        amount_less += 1
        less.append(m - el)
    else:
        amount_mid += 1


need_to_change = max(abs(amount_more - amount_less) - max(amount_mid - 1, 0), 0)

if(need_to_change % 2 == 1):
    need_to_change //= 2
    need_to_change += 1
else:
    need_to_change //= 2

changes = 0

if(need_to_change > 0):
    if(amount_more > amount_less):
        different = heapq.nsmallest(need_to_change, more)
    else:
        different = heapq.nsmallest(need_to_change, less)

    for el in different:
        changes += el


print(changes)






