n = int(input())
l1 = sorted(list(map(int, input().split(' '))))
l2 = sorted(list(map(int, input().split(' '))))
l3 = sorted(list(map(int, input().split(' '))))
l2.append('')
l3.append('')
l3.append('')

for i in range(len(l2)):
    if l1[i]!=l2[i]:
        print(l1[i])
        break
for i in range(len(l3)):
    if l2[i] != l3[i]:
        print(l2[i])
        break