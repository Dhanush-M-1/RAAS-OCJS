def counting(n):
    minimum = 0
    while True:
        if  n == 1:
            return minimum
        if n % 6 == 0 or n % 3 == 0:
            if n % 6 == 0:
                n = n // 6
                minimum = minimum + 1
            else:
                n = n * 2
                minimum = minimum + 1
        else:
            return -1


### ### ### PROGRAM ### ### ###
howManyNumber = int(input())
for i in range(0, howManyNumber):
    N = int(input())
    if N == 1:
        print("0")
    else:
        print(counting(N))