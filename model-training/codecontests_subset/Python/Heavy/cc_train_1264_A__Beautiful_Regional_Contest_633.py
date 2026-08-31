import sys
def input():
    return sys.stdin.readline()
for j in range(int(input())):
    n = int(input())
    c = list(map(int,input().split()))
    maximum = n//2
    s = [[c[0],0]]
    for i in c:
        if s[-1][0]==i:
            s[-1][1]+=1
        else:
            s.append([i,1])
    gold,silv,bron = 0,0,0
    if len(s)<=3:
        print(0,0,0)
        continue
    gold = s[0][1]
    silv = s[1][1]
    i = 2
    n= len(s)
    while gold>=silv and i!=n:
        silv+=s[i][1]
        i+=1
    summa = gold+silv

    while i!=n and s[i][1]+summa<= maximum:
        summa+= s[i][1]
        bron += s[i][1]
        i+=1
    if summa> maximum or gold*silv*bron==0 or gold>=silv or bron<=gold:
        print(0,0,0)
    else:
        print(gold,silv,bron)