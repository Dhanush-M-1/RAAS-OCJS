def countSteps(num):
    count = 0
    while num > 1:
        if num % 6 == 0:
            num = num//6
            count += 1
        elif num % 2 == 0:
            print(-1)
            return
        else:
            num = 2*num
            count += 1
    print(count)
    return

def solveA():
    
    #Get input:
    t = int(input())
    lst = []
    for i in range(t):
        lst.append(int(input()))
        
    #Solve:
    for num in lst:
        countSteps(num)
        
    return

solveA()