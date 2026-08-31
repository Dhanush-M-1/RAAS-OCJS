n = int(input())
l1 = (input().split(' '))
l2 = (input().split(' '))
l3 = (input().split(' '))

l1.sort()
l2.sort()
l3.sort()

fl = True
for i in range(n-1):
    if l1[i] != l2[i]:
        print(l1[i])
        fl = False
        break
if fl:
    print(l1[n-1])

fl = True
for i in range(n-2):
    if l2[i] != l3[i]:
        print(l2[i])
        fl = False
        break
if fl:
    print(l2[n-2])
