n, m = [int (i) for i in input().split()]
ctr = 0
while (n!=0):
    ctr += 1
    n -= 1
    if (ctr %m == 0):
        n+=1
print (ctr)