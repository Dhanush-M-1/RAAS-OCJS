t = int(input())
for isc in range(t):
    n = int(input())
    count3 = 0
    count2 = 0
    if(n==1):
        print(0)
        continue
    f = False
    while(n!=1):
        if(n%3==0):
            n=n//3
            count3+=1
        elif(n%2==0):
            n=n//2
            count2+=1
        else:
            f = True
            break
    if f:
        print('-1')
    else:
        if(count2==count3):
            print(count2)
        elif(count2>count3):
            print('-1')
        else:
            print(2*count3 - count2)