n = int(input())
a = 1000000000
for i in range (n):
    m = int(input())
    count3 = 0
    count2 = 0
    for j in range(a):
       if m % 3 == 0:
           m = m / 3
           count3 += 1
       else:
           if m / 2 % 1 == 0:
               m = m / 2
               count2 += 1
           elif m == 1:
               break
           else:
                count2 = 1
                count3 = 0
                break
    if count3 >= count2:
        print (2*count3 - count2)
    else:
        print(-1)