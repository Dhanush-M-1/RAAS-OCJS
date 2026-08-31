n,l = [int(i) for i in input().split()]
counter = n

rem = n//l

while(rem>0):
    counter+=rem
    n = n%l + n//l
    rem = n//l
print(counter)