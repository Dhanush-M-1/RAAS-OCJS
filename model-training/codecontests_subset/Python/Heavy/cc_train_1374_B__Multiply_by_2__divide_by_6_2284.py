def isPower (x, y):
    if (x == 1): 
        return (y == 1)
    pow = 1
    count =0
    while (pow < y): 
        pow = pow * x 
        count +=1
    if(pow == y):
        return count
    else:
        return -1 



def isdiv(n):
    count = 0 
    while(n > 1):
        if(n%6 != 0):
            po = isPower(3,n)
            if(po == -1):
                return -1
            else:
                return count + 2*po
        n = n/6
        count+=1
    return count



t = int(input())
for i in range(t):
    n = int(input())
    if(n==0):
        print(-1)
        continue
    if(n%2 != 0 ):
        x = isPower(3,n)
        if(x == -1):
            print(-1)
        else:
            print(x*2)
    else:
        c1 = isdiv(n)
        if(c1 == -1):
            print(-1)
        else:
            print(c1)

