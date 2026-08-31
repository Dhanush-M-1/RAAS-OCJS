for _ in range(int(input())): 
    n = int(input())
    if(n==1): 
        print(0)
    else : 
        count = 0 
        flag = 0 
        while (n!=1) : 
            
            if(n%3 == 0 ): 
                if (n%2 == 0 ): 
                    n = n//6 
                    count += 1 
                else : 
                    n = n//3 
                    count += 2 
            else : 
                flag = 1
                break 

            
        if flag==1 : 
            print(-1)
        else : 
            print(count)
