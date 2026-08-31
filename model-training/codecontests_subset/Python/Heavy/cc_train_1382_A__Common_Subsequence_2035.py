import sys
input = sys.stdin.readline

# input 


t = int(input())

# for looping 

for _ in range(t):
    n, m = map(int, input().split())
    
    # listing 
    
    nList = list(map(int, input().split()))
    mList = list(map(int, input().split()))


# boolean init 

    flag = False
    
    # for looping 
    
    for i in nList:
        if i in mList:
            
            # answer 
            
            print('YES')
            
            # 
            print(1, i)
            
            # bools
             
            flag = True
            break
        
        # else 0
    if flag == False:
        
        # answer 
        
        print('NO')