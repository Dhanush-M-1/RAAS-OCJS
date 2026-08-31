for _ in range(int(input())):
    n = int(input())
    count_2 = 0
    count_3 = 0
    if n==1:
        print(0)
    else:  
        while n!=1:
            if n%3==0:
                n = n//3
                count_3 = count_3 + 1
            else:
                break
        while n!=1:
            if n%2==0:
                n = n//2
                count_2 = count_2 +1
            else:
                break        
        if count_2>count_3:
            print(-1)
        elif (count_2<=count_3) and n==1:
            print(count_3*2 - count_2)
        else:
            print(-1)
            

    
                