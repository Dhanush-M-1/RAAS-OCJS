n = int(input())
a = list(map(int, input().split()))
ec = 0
oc = 0
even = []
odd = []

a.sort()

for i in a:
    if i % 2 == 0:
        even.append(i)
    else:
        odd.append(i)
even2 = even.copy()
odd2 = odd.copy()

for i in range(n):
    if i % 2 == 0 and even:
        even.pop()
    elif i % 2 != 0 and odd:
        odd.pop()
    if (i % 2 == 0 and not odd) or (i % 2 != 0 and not even):
        break
sum1 = sum(even) + sum(odd)

for i in range(n):
    if i % 2 != 0 and even2:
        even2.pop()
    elif i % 2 == 0 and odd2:
        odd2.pop()
    if (i % 2 == 0 and not even2) or (i % 2 != 0 and not odd2):
        break
sum2 = sum(even2) + sum(odd2)

print(min(sum1, sum2))
