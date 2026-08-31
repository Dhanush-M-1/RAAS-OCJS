N,P = map(int, input().split())

if P == 1 :
    print(1)
elif N == 1:
    print(P)
else:
    import math

    sq_P = math.floor(math.sqrt(P))
    prim = []
    P_tmp=P

    for i in range(2,sq_P):
        r=0
        if P_tmp%i == 0:
            r+=1
            P_tmp=P_tmp/i
            while P_tmp%i==0:
                r+=1
                P_tmp=P_tmp/i
            prim.append([i,r])

    ans = 1
    for i in range(len(prim)):
        if prim[i][1]>=N:
            ans = ans * prim[i][0]**math.floor(prim[i][1]/N)

    print(ans)