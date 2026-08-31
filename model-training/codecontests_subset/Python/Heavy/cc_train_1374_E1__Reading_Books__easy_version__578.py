n, k = map(int, input().split())
main = []
for i in range(n):
    l = list(map(int, input().split()))
    main.append(l)

list01 = []
list10 = []
list11 = []

for i in main:
    if i[1] == 0 and i[2] == 1:
        list01.append(i)
    elif i[1]== 1 and i[2] == 0:
        list10.append(i)
    elif i[1] == 1 and i[2] == 1:
        list11.append(i)

list01.sort()
list10.sort()

newlist11 = []
l1 = len(list01)
l2 = len(list10)
sum = 0
for i in range(0, min(l1, l2)):
    sum = list01[i][0] + list10[i][0]
    newlist11.append([sum, 1, 1])

finallist = []
finallist = list11 + newlist11
finallist.sort()
add = 0
if len(finallist) < k:
    print(-1)
else:
    for i in range(0, k):
        add += finallist[i][0]
    print(add)