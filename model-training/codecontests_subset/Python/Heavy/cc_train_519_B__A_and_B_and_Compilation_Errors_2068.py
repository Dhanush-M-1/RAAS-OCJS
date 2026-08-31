n = int(input())
aline = input().split(' ')
bline = input().split(' ')
cline = input().split(' ')
a = [int(i) for i in aline]
b = [int(i) for i in bline]
c = [int(i) for i in cline]

def dicfunc(abc):
    dic = dict()
    for i in abc:
        if i in dic.keys():
            dic[i] += 1
        else:
            dic[i] = 1
    return dic

dica, dicb, dicc = dicfunc(a), dicfunc(b), dicfunc(c)

for i in dica.keys():
    if (i not in dicb.keys()) or (dica[i] > dicb[i]):
        print(i)
        break

for i in dicb.keys():
    if (i not in dicc.keys()) or (dicb[i] > dicc[i]):
        print(i)
        break
