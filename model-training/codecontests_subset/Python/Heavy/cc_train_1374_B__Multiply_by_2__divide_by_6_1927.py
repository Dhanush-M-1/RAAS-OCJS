# cook your dish here
for _ in range(int(input())):
    n = int(input())
    count = 0 
    ans = 0
    flag = True
    if( n==1):
        print(0)
    elif(n % 3 != 0 and n !=1):
        print(-1)
    else:
        while(n != 1):
            if( n % 6 == 0):
                n = n // 6
                count =0  
                ans += 1
            elif(n % 3 == 0):
                n = n // 3 
                count +=1
                ans += 2
            elif(n % 3 != 0):
                flag = False
                print(-1) 
                #exit()
                break
        if(flag):
            print(ans)
    
        
        