T = int(input())
dic = {}
 
def is_2power(K):
    
    if K == 2:
        return True
    
    temp = 2
    
    while(True):
        
        temp *= 2
        
        if temp == K:
            
            return True
        
        if temp > K:
            
            return False
        
        
    
def Fun(num, moves, Mult):
    
    if num in dic:
        
        return dic[num]
        
    temp = num
    
    while(True):
        
        # print(None)
        
        if Mult > 10:
            
            dic[num] = -1
            
            return -1
        
        if temp == 1:
            
            dic[num] = moves
            
            return moves
        
        if temp == 0 or is_2power(temp):
            
            dic[num] = -1
            
            return -1
            
        # print(num)
        
        if (temp % 6) == 0:
            
            temp /=  6
            
            Mult = 0
            
            moves += 1
        
        else:
            
            temp *= 2
            
            Mult += 1
            
            moves += 1
        
     
for i in range(T):
    
    n = int(input())

    print(Fun(n, 0, 0))

# print(dic)
    