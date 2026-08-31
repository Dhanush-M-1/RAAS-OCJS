import math
for _ in range(int(input())):
    abc = list(str(input()).split(" "))
    a = int(abc[0])
    b = int(abc[1])
    c = int(abc[2])
    
    stone = 0
    
    if(c >=2 and b >= 1):
        if(b >= math.floor(c/2)):
            stone += math.floor(c/2) * 3
            b -=  math.floor(c/2)
        else:
            stone += 3 * b
            b = 0
    if(b >=2 and a >= 1):
        if(a >= math.floor(b/2)):
            stone += math.floor(b/2) * 3
            
        else:
            stone += 3 * a

    print(stone)
