import math

def twoch(k):
    if len(str(round(k))) == 1:
        ans = '0' + str(round(k))

    else:
        ans = str(round(k))

    return(ans)

while True:
    lst = list(input().split())
    if lst[0] == '-1':
        break

    T, H, S = int(lst[0]), int(lst[1]), int(lst[2])

    s = 3600*T + 60*H + S
    Sa = 7200 - s
    Sb = 3*Sa

    Ta = Sa//3600
    Sa = Sa - 3600*Ta
    Ha = Sa//60
    Sa = Sa - 60*Ha

    Tb = Sb//3600
    Sb = Sb - 3600*Tb
    Hb = Sb//60
    Sb = Sb - 60*Hb
    
    print(twoch(Ta)+ ':'+ twoch(Ha)+ ':'+ twoch(Sa))
    print(twoch(Tb)+ ':'+ twoch(Hb)+ ':'+ twoch(Sb))
