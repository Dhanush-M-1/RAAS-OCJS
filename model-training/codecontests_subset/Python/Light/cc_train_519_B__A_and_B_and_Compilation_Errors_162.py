from collections import Counter

n = int(input())
second = [int(c) for c in input().split()]
third = [int(c) for c in input().split()]
fourth = [int(c) for c in input().split()]

count2 = Counter(second)
count3 = Counter(third)
count4 = Counter(fourth)

error1 = None
error2 = None
for x in second:
    if count2[x] != count3[x]:
        error1 = x
        break

for x in third:
    if count3[x] != count4[x]:
        error2 = x
        break

print(error1)
print(error2)
