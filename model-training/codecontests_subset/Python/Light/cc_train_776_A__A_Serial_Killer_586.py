p2 = str(input())
lst = []
lst.append(p2.split(' '))
num = int(input())
for i in range(num):
    lst.append(str(input()).split(' '))

for i in range(len(lst)):
    if (i == 0):
        print(' '.join(lst[0]))
    else:
        if lst[i][0] == lst[i-1][0]:
            lst[i][0] = lst[i][1]
            lst[i][1] = lst[i-1][1]
            print(' '.join(lst[i]))
        else:
            lst[i][0] = lst[i-1][0]
            print(' '.join(lst[i]))
