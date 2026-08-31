n = int(input())
a = []
for i in range(n):
    b = int(input())
    a.append(b)
op1 = 1
op2 = 2
see = 3
ok = True
for i in range(n):
    if a[i] == 1:
        if op1 == 1:
            op2, see = see, op2
            #swap(op2, see)
        elif op2 == 1:
            op1, see = see, op1
            #swap(op1, see)
        else:
            ok = False
    if a[i] == 2:
        if op1 == 2:
            op2, see = see, op2
        elif op2 == 2:
            op1, see = see, op1
        else:
            ok = False
    if a[i] == 3:
        if op1 == 3:
            op2, see = see, op2
        elif op2 == 3:
            op1, see = see, op1
        else:
            ok = False
    if ok == False:
        break
if ok:
    print("YES")
else:
    print("NO")