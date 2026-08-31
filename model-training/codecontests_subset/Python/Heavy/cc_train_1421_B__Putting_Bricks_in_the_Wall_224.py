t = int(input())

for _ in range(t):
    n = int(input())

    arr = input()
    # print(arr)

    el12 = int(arr[1])

    arr = input()
    # print(arr)

    el21 = int(arr[0])

    if n == 3:
        el34 = int(arr[n-1])
        arr = input()
        el43 = int(arr[n-2])

    else:
        for _ in range(n-4):
            arr = input()
            # print(arr)

        arr = input()
        # print(arr)
        el34 = int(arr[n-1])

        arr = input()
        # print(arr)
        el43 = int(arr[n-2])



    need = 2 - abs((el12+ el21)- (el34+ el43))

    print(need)

    if need == 2:
        if el12 == el21 == el34== el43:
            print(1,2)
            print(2,1)
        
        else:
            if el12 !=1 : print(1,2)

            if el21 !=1 : print(2,1)

            if el34 != 0: print(n-1, n)

            if el43 != 0: print(n, n-1)
    
    if need == 1:
        if el12 == el21:
            if el34 == el12: print(n-1, n)

            else: print(n, n-1)
        
        else:
            if el12 == el34: print(1, 2)

            else: print(2,1)




"""
End of code 70 lines.
"""
