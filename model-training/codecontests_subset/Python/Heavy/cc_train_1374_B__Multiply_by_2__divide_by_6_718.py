for _ in range(int(input())):
    n = int(input())
    if n==1:
        print(0)
    elif n%6!=0 and n%3 != 0:
        print(-1)
    else:
        checker = True
        count = 0
        while n!=1:
            if n%6 == 0:
                n//=6
                count+=1
            elif n%3==0:
                n*=2
                count+=1
            else:
                if n!=1:
                    checker = False
                    print(-1)
                    break
        if checker:
            print(count)
                
    


    
