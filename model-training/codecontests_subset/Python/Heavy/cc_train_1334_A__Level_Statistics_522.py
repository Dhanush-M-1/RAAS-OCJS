t = int(input())
for T in range(t):
    n = int(input())
    #print("n ", n)
    L_prec = [0, 0]
    giusto = True
    for N in range(n):
        L = list(map(int, input().split()))
        #print("L ",L)
        #print(L)
        #if ((L[0] == L_prec[0]+1) and (L[1] == L_prec[1]+1)):
        #    pass
        #elif ((L[0] == L_prec[0]+1) and (L[1] == L_prec[1])):
        #    pass
        #elif((L[0] == L_prec[0]) and (L[1] == L_prec[1])):
        #    pass
        if (L[0] >= L_prec[0] and L[1] >= L_prec[1]):
            if(L[1]-L_prec[1] > L[0]-L_prec[0]):
                print("NO")
                giusto = False
                break
            else:
                L_prec = []
                for x in L:
                    L_prec.append(x)
                L = []
            #    pass
                #print("YES")
        else:
            print("NO")
            giusto = False
            break
    #print("N ", N)
    if giusto:
        print("YES")

    for x in range((n-1)-N):
        L = list(map(int, input().split()))
