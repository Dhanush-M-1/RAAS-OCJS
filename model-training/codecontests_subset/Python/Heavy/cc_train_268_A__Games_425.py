n=int(input())
zidian={}
ts=0
lzhuchang=[]
for i in range(n):
    a,b=[int(j) for j in input().split()]
    while (a,ts) in zidian:
        ts+=1
    zidian[(a,ts)]=b
    lzhuchang.append((a,ts))
lkechang=[]
jieguo=0
for zhuchangsehao in lzhuchang:
    for k,v in zidian.items():
        if zhuchangsehao==k:
            continue#continue means not to do requests which are after "for k,v in zidian.items()
            #in particular, continue means not to do "l2.append(v)"
        lkechang.append(v)#up to now,l2 is all of the colors except the zhuchang itself.
    for kechangsehao in lkechang:
        if zhuchangsehao[0]==kechangsehao:
            jieguo+=1
    lkechang.clear()

print(jieguo)