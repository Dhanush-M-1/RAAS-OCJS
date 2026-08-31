n, k = list(map(int, input().split()))
both = []
a = []
b = []
for item in range(n):
    buff = list(map(int, input().split()))
    if buff[1] == 1 and buff[2] == 1:
        both.append(buff[0])
    elif buff[1] == 1:
        a.append(buff[0])
    elif buff[2] == 1:
        b.append(buff[0])

both.sort()
a.sort()
b.sort()
rez = 0
both_ind = 0
tog_ind = 0
while k > 0:
    if (len(a) - tog_ind > 0 and len(b) - tog_ind > 0):
        if len(both) - both_ind > 0:
            if(a[tog_ind] + b[tog_ind] < both[both_ind]):
                rez += a[tog_ind] + b[tog_ind]
                k -= 1
                tog_ind += 1
            else:
                rez += both[both_ind]
                k -= 1
                both_ind += 1
        else:
            k -= 1
            rez += a[tog_ind] + b[tog_ind]
            tog_ind += 1
    elif len(both) - both_ind > 0:
        k -= 1
        rez += both[both_ind]
        both_ind += 1
    else:
        print(-1)
        exit()
print(rez)
