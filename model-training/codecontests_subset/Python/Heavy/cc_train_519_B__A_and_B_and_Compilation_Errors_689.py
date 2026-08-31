n = int(input())
l1 = sorted(list(map(int, input().split())))
l2 = sorted(list(map(int, input().split())))
l3 = sorted(list(map(int, input().split())))

er1 = l1[n-1]
er2 = l2[n-2]

for i, j in zip(l1, l2):
    if i != j:
        er1 = i
        break

for i, j in zip(l2, l3):
    if i != j:
        er2 = i
        break
print(er1)
print(er2)

'''
ans = []
n = int(input())
l1 = list(map(int, input().split(" ")))
l2 = list(map(int, input().split(" ")))
l3 = list(map(int, input().split(" ")))
l1.sort()
l2.sort()
l3.sort()
for error in l1:
    if not error in l2:
        ans.append(error)
        break
for error in l2:
    if not error in l3:
        ans.append(error)
        break

for x in ans:
    print(x)
'''
