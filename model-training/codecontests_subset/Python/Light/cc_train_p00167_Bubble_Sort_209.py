while True:
    n = int(input())
    if n == 0:
        break
    Num_lis = []
    cou = 0
    for i in range(n):
        Num_lis.append(int(input()))
    S_lis = sorted(Num_lis)
    while Num_lis != S_lis:
        
        for j in range(n - 1):
            if Num_lis[j] > Num_lis[j + 1]:
                Num_lis[j],Num_lis[j + 1] = Num_lis[j + 1],Num_lis[j]
                cou += 1
    print(cou)