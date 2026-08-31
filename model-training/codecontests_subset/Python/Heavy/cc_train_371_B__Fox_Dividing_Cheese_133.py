cntOne,cntTwo = list(map(int,input().split()))
result = 0
arrDel = []
arrBel = []
c = 0
c1 = 0
pn = 0
if cntOne > cntTwo:
    pn = cntOne
else:
    pn = cntTwo
for i in range(pn):
    if cntOne == 1 and cntTwo == 1 or c >= 1 and c1 >= 1:
        break
    if cntOne < cntTwo and  c1 == 0 or c == 1:
        if cntTwo % 2 == 0:
            cntTwo //= 2
            arrDel.append(2)
        elif cntTwo % 3 == 0:
            cntTwo //= 3
            arrDel.append(3)
        elif cntTwo % 5 == 0:
            cntTwo //= 5
            arrDel.append(5)
        else:
            c1 += 1
    else:
        if cntOne % 2 == 0:
            cntOne //= 2
            arrBel.append(2)
        elif cntOne % 3 == 0:
            cntOne //= 3
            arrBel.append(3)
        elif cntOne % 5 == 0:
            cntOne //= 5
            arrBel.append(5)
        else:
            c += 1
result = result + abs(arrDel.count(2) - arrBel.count(2))
result = result + abs(arrDel.count(3) - arrBel.count(3))
result = result + abs(arrDel.count(5) - arrBel.count(5))
if cntTwo != cntOne:
    print('-1')
else:
    print(result)