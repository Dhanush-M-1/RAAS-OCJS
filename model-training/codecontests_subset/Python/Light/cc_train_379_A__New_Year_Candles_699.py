
a,b = map(int,input().split(' '))

Candels = a
Hours = 0

while Candels != 0:
    
    Hours +=1
    Candels -=1
    if Hours % b == 0:
        Candels +=1
        
print(Hours)
    
