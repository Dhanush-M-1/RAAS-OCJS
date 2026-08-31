#B
t = int(input())
for tc in range(t):
    n = int(input())
    save = n
    flag = 0
    count = 0
    while(n != 1):
        while(n % 6 == 0):
            n = n/6

            count += 1
            if(n == 1):
                print(count)
                flag = 1
                break
        while(n % 6 != 0 and flag != 1):
            n *= 2 
            count += 1
            if(n > 4*save):
                print('-1')
                flag = 1
                break
            if(n == 1):
                print(count)
                flag = 1
                break
        if(flag == 1):    
            break
        
    if(n == 1 and flag == 0):
        print(count)
