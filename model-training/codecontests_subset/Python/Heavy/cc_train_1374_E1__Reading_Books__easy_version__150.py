n,m,k = input().split(' ')
n,m,k = int(n),int(m),int(k)
      
A = []
B = []
C = []
D = []
Ainmax = 0
Binmax = 0
Cinmax = 0
Dinmax = 0

for i in range(n):
    entry = input().split(' ')
    if entry[1] == '1' and entry[2] == '1':
        C.append([int(entry[0]),i+1])
        Cinmax+=1
    elif entry[1] == '1' and entry[2] == '0':
        A.append([int(entry[0]),i+1])
        Ainmax+=1
    elif entry[1] == '0' and entry[2] == '1':
        B.append([int(entry[0]),i+1])
        Binmax+=1
    else:
        D.append([int(entry[0]),i+1])
        Dinmax+=1

A.sort(key = lambda x: x[0])    
B.sort(key = lambda x: x[0])    
C.sort(key = lambda x: x[0])    
D.sort(key = lambda x: x[0])    

mi = min(Ainmax,Binmax)

if len(C) + mi < k:
    print(-1)
elif len(C)<k and 2*k - len(C)>m:
    print(-1)
else:
    time = 0
    Ain = 0
    Bin = 0
    Cin = 0
    Din = 0
    ABinmax = min(mi,m-k)
    for i in range(k):
        if Ain == ABinmax:
            Cin += 1
        elif Cin == Cinmax or A[Ain][0]+B[Bin][0] <= C[Cin][0]:
            Ain += 1
            Bin += 1
        else:
            Cin += 1
            
    for i in range(m-Ain-Bin-Cin):
        pot = []
        if Ain < Ainmax:
            pot.append([A[Ain][0],'Ain+=1'])
        if Bin < Binmax:
            pot.append([B[Bin][0],'Bin+=1'])
        if Cin < Cinmax:
            pot.append([C[Cin][0],'Cin+=1'])
        if Din < Dinmax:
            pot.append([D[Din][0],'Din+=1'])
        if Ain < Ainmax and Bin < Binmax and Cin!=0:
            pot.append([A[Ain][0] + B[Bin][0] - C[Cin-1][0],'Ain+=1;Bin+=1;Cin-=1'])
        minpot = 0
        for j in range(len(pot)-1):
            if pot[minpot][0]>pot[j+1][0]:
                minpot = j+1
        exec(pot[minpot][1])

    for i in range(Ain):
        time += A[i][0]
    for i in range(Bin):
        time += B[i][0]
    for i in range(Cin):
        time += C[i][0]
    for i in range(Din):
        time += D[i][0]

    print(time)
    for i in range(Ain):
        print(A[i][1],end = ' ')
    for i in range(Bin):
        print(B[i][1],end = ' ')
    for i in range(Cin):
        print(C[i][1],end = ' ')
    for i in range(Din):
        print(D[i][1],end = ' ')
