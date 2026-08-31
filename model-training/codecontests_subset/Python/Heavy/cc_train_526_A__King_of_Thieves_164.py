n=int(input())
d=list(input())
dun = list()
ok =False
initial = 0
for i in range(len(d)):
    if d[i]=='.':
        dun.append(False)
    else :
        dun.append(True)
        if ok == False:
            initial = i
            ok = True
ok = False
if (n-initial)//4 == 0:
    print('no')
else :
    while initial+1<len(dun) and not ok:
        for i in range(1, (n-initial)//4+1):
            nok = False
            count=0
            for j in range(initial,n,i):
                if dun[j]== False:
                    nok=True
                    break
                else :
                    count += 1
                if count == 5:
                    break
            if nok==False and count ==5:
                ok=True
                break
        if not ok :
            initial += 1
            while initial+1>len(dun) and dun[initial]==False:
                initial += 1
        else :
            break
    if not ok:
        print('no')
    else :
        print('yes')