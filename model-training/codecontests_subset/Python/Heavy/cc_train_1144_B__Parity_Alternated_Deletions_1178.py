import math

n = int(input())
l = list(map( int , input().split()))
countOdd=0
countEven=0
for i in range(0,n):
    if l[i]%2==0:
        countOdd +=1
    else:
        countEven +=1
# print(countEven , " " , countOdd)
l.sort()
if (abs(countEven-countOdd)==0 or abs(countEven-countOdd)==1):
    print(0)
    exit(0)
sums = 0
if (countEven>countOdd):
    k = countEven - countOdd - 1
    while (True):
        for i in range(0,n):
            if (l[i]%2!=0):
                sums += l[i]
                k -=1
            if (k==0):
                print(sums)
                exit(0)
else:
    k = countOdd - countEven - 1
    while (True):
        for i in range(0,n):
            if (l[i]%2==0):
                sums += l[i]
                k -=1
            if (k==0):
                print(sums)
                exit(0)
    

