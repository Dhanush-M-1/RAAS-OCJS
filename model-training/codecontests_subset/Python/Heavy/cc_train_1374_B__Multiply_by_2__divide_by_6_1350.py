testcases = int(input())
for testcase in range(testcases):
    n = int(input())
    if n == 1:
        print(0)
        continue 
    if n == 2 or n == 4 or n ==5:
        print(-1)
        continue 
    if n == 3:
        print(2)
        continue
    
    count = 0 
    flag = 0 
    while True:
        if n == 1:
            flag = 1
            print(count)
            break 
        if n == 2 or n == 4 or n ==5:
            print(-1)
            flag = 1
            break 
        if n == 3:
            flag = 1
            print(count + 2)
            break
        #print("n is " + str( n) )
        if n & 1 == 0 and n % 6 != 0:
            break
        if n & 1 == 0 and n % 6 == 0 :
            n = n // 6 
            count += 1 
            continue 
        count += 1 
        n  = n << 1
        
    if flag == 0 :
        print(-1)
        
        
        