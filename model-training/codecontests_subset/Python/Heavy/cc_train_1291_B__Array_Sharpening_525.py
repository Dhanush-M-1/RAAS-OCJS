tc = int(input())
for ix in range(0, tc):
    n  = int(input())
    arr=[int(x) for x in input().split()]
    ml =-1
    for i, el in enumerate(arr):
        if el >= i:
            ml = i
        else:
            break
    if ml >= 0:
        mr =-1
        for i, el in reversed(list(enumerate(arr))):
            if el >= n - 1 - i:
                mr = i
            else:
                break
        if ml >= mr:
            print("Yes")
        else:
            print("No")
    else:
        print("No")
        
        
        
