amt = int(input(''))
for i in range(amt):
    n = int(input(''))
    listnum = []
    ans = []
    loop = True
    if n == 1:
        print(0)
    else:
        while loop:
            if n % 6 == 0:
                n = n/6
                listnum.append(1)
            elif n % 3 == 0:
                n = n/3
                listnum.append(1)
                listnum.append(1)
            else:
                loop = False
        if n == 1:
            print(len(listnum))
        else:
            print(-1)
            
    
