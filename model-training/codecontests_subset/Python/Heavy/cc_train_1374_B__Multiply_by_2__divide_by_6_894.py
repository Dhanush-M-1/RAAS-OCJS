def isPowerOfTwo (x):
    return (x and (not(x & (x - 1))) )
for _ in range(int(input())):
    n=int(input())
    if n==1:
        print(0)
    elif isPowerOfTwo(n):
        print(-1)
    else:
        c=0
        while True:
            if n%6==0:
                n=n//6
                c+=1
            elif (n*2)%6==0:
                n=n*2
                c+=1
            elif n==1:
                break
            else:
                break
        if(n!=1):
            print(-1)
        else:
            print(c)