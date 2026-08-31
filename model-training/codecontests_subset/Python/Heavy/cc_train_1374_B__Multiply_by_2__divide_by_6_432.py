for _ in range(int(input())):
    n = int(input())
    if n == 1:
        print(0)
        continue
    
    temp = int(n)
    # print(f"Temp before twos loop:{temp}")
    twos, threes = 0, 0
    while temp != 0:
        if temp%2 == 0:
            twos += 1
            temp //= 2
        else:
            break
        
    temp = int(n)
    # print(f"Temp before threes loop:{temp}")
    while temp != 0:
        if temp%3 == 0:
            threes += 1
            temp //= 3
        else:
            break
    
    flag = False
    if twos == 0 and threes == 0:
        flag = True
    elif (n // ((2 ** twos) * (3 ** threes))) != 1:
        flag = True
        
    if twos > threes or flag:
        print(-1)
    elif twos < threes:
        print(2*threes-twos)
    else:
        print(threes)