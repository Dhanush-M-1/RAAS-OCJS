for _ in range(int(input())):
    n=int(input())
    if n==1:
        print('0')
    else:
        twocnt=0
        threecnt=0
        flag=1
        while(flag==1 and n>1):
            if n%2==0:
                flag=1
                while n % 2 == 0: 
                    n = n // 2
                    twocnt+=1
                if n==1:
                    break
            elif n%3==0:
                flag=1
                while n % 3 == 0: 
                    n = n // 3
                    threecnt+=1
                if n==1:
                    break
            else:
                flag=0
                break   
        if twocnt>threecnt or flag==0:
            print('-1')
        else:    
            moves=0
            #print(twocnt,threecnt)        
            moves+=(threecnt-twocnt)
            moves+=threecnt
            print(moves)
         