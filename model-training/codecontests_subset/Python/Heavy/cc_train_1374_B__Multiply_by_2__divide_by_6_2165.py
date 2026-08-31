# import sys # no
# sys.stdin = open("input2") # no

number      = int(input())

for iTask in range(number):
    n = int(input())
    if n==1:
        print(0)
    elif n==2:
        print(-1)
    elif n==3:
        print(2)
    else:
        pow3 = 0
        divisible = n%3
        while (divisible == 0) and (n>2):
            n = int(n/3)
            pow3 += 1
            divisible = n%3
        pow2 = 0
        divisible = n%2
        while (divisible == 0) and (n>1):
            n = int(n/2)
            pow2 += 1
            divisible = n%2
        if (n==1) and (pow3 >= pow2):
            print(pow3-pow2 + pow3)
        else:
            print(-1)