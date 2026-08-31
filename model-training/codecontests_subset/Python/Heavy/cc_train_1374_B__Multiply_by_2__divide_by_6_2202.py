for i in range(int(input())):
    n=int(input())
    if n==1:print('0')
    elif n%2!=0 and n%3!=0:(print('-1'))
    elif n%2==0 and n%3!=0:print('-1')
    else:
        k=n
        c=0
        while(k!=1):
            if k%3==0:
                f=0
                if (k%6==0):
                    k=k//6
                    c+=1
                else:
                    k=k*2
                    c+=1
            else:
                f=1
                break
        if f==0:print(c)
        else:print('-1')

