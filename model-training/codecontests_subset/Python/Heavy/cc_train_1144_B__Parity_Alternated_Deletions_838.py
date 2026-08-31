n = int(input())
nums = list(map(int, input().split(' ')))
even = []
odd = []
for i in nums:
    if i % 2 == 0:
        even.append(i)
    else:
        odd.append(i)
even.sort()
odd.sort()
even1=even.copy()
odd1=odd.copy()
min1 = 0
min2 = 0
m, n = len(even), len(odd)
for i in range(min(m, n)):
    even.pop()
    odd.pop()
if len(even) != 0:
    even.pop()

min1 = sum(odd) + sum(even)
for i in range(min(m, n)):
    odd1.pop()
    even1.pop()
if len(odd) != 0:
    odd1.pop()
min2 = sum(odd1) + sum(even1)
print(min(min1, min2))
