T = int(input())

for i in range(T):
    n = int(input())
    Oboje_list = []
    for j in range(n):
        Oboje_list.append(list(map(int,input().split())))

    P_list = []
    C_list = []
    for x in range(len(Oboje_list)):
        P_list.append(Oboje_list[x][0])
        C_list.append(Oboje_list[x][1])


    Value = 1
    
    P2 = sorted(P_list)
    C2 = sorted(C_list)

    if P2 != P_list:        #ovo provjerava jeli se broj p smanjio
        Value = 0
    if C2 != C_list:        #ovo provjerava jeli se broj c smanjio
        Value = 0
    
    for B in range(len(P2)):  # ovo provjerava jeli broj pobjeda veći od broja pokušaja
        if C2[B] > P2[B]:
                Value = 0
    for B in range(1,len(P2)):
        DELTA_P = P2[B] - P2[B-1]
        DELTA_C = C2[B] - C2[B-1]
        if DELTA_C > DELTA_P:
            Value = 0
    


    

    if Value == 0:
        print('NO')
    else:
       print('YES')


    Oboje_list.clear()
    P_list.clear()
    C_list.clear()
    
