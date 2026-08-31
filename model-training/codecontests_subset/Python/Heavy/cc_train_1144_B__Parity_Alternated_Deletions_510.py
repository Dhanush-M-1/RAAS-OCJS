n = int(input())
inp = input()
jor = []
bijor = []
cjor = 0
cbijor = 0
for i in range(0, n):
    allinp = inp.split(" ")
for j in range(0, n):
    if int(allinp[j]) % 2 == 0:
        jor.append(int(allinp[j]))
        cjor += 1
    else:
        bijor.append(int(allinp[j]))
        cbijor += 1
all = sum(jor) + sum(bijor)
chk = 0
if cjor == cbijor or cjor-1 == cbijor or cjor==cbijor-1:
    print("0")
else:
    if sum(jor) > sum(bijor):
        while len(jor)!=0 or len(bijor)!=0:
            if len(jor)!=0:
                all -= max(jor)
                jor.remove(max(jor))
            else:
                chk = 1
            if len(bijor)!=0:
                all -= max(bijor)
                bijor.remove(max(bijor))
            else:
                chk = 1
            if chk == 1:
                break
    else:
        while len(jor)!=0 or len(bijor)!=0:
            if len(bijor)!=0:
                all -= max(bijor)
                bijor.remove(max(bijor))
            else:
                chk = 1
            if len(jor)!=0:
                all -= max(jor)
                jor.remove(max(jor))
            else:
                chk = 1
            if chk == 1:
                break
    print(all)


