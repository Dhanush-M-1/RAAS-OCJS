for _ in range(int(input())):
    n = int(input())
    if n==1:
        print('0')
    elif n%3!=0:
        print('-1')
    else:
        x = 1
        c = 0
        t = 0
        while True:
            if x==n:
                t = 1
                print(c)
                break
            elif x>n:
                x//=2
                c+=1
                if x>n and x%2!=0:
                    break
            else:
                x*=6
                c+=1
        if t==0:
            print('-1')