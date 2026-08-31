mass = input().split()
length = mass.count('?')
tmp_mass = [1]
flag = False
for i in range(1, (length - 1) * 2, 2):
    if mass[i] == '+':
        tmp_mass.append(1)
    else:
        tmp_mass.append(-1)
tmp_sum = sum(tmp_mass)
summ = int(mass[len(mass)-1])
for i in range(length):    
    if tmp_mass[i] > 0:
        tmp_mass[i] = summ - sum(tmp_mass) + tmp_mass[i]
        if tmp_mass[i] >= summ:
            tmp_mass[i] = summ
        elif tmp_mass[i] <= 1:
            tmp_mass[i] = 1
        else:
            flag = True
            break
    else:
        tmp_mass[i] = summ - sum(tmp_mass) + tmp_mass[i]
        if tmp_mass[i] >= -1:
            tmp_mass[i] = -1
        elif abs(tmp_mass[i]) >= summ:
            tmp_mass[i] = -summ
        else:
            flag = True
            break
if sum(tmp_mass) == summ:
    flag = True
else:
    flag = False
    
for i in range(len(mass)):
    if mass[i] == '?':
        mass[i] = abs(tmp_mass.pop(0))
if flag:
    print('Possible')
    print(' '.join(list(map(str, mass))))
else:
    print('Impossible')
