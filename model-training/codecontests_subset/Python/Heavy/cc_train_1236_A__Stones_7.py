for i in range(int(input())):
    X = list(map(int , input().split()))
    Temp = X[:]
    SUM = 0
    SUM1 = 0
    while X[0]>=1 and X[1]>=2:
        SUM+=3
        X[0] , X[1] = X[0] -1 , X[1]- 2
    while X[1]>=1 and X[2]>=2:
        SUM+=3
        X[1] , X[2] = X[1] -1 , X[2]- 2
        
    while Temp[1]>=1 and Temp[2]>=2:
        SUM1+=3
        Temp[1] , Temp[2] = Temp[1] -1 , Temp[2]- 2
    while Temp[0]>=1 and Temp[1]>=2:
        SUM1+=3
        Temp[0] , Temp[1] = Temp[0] -1 , Temp[1]- 2
    print(max(SUM,SUM1))
    