t = int(input())

while t>0:
    a, b, c = map(int, input().split())
    sumF = 0
    if b==0:
        print(sumF)
    else:
        tempC = c//2
        if tempC >= b:
            print(b*2+b)
        else:
            b = b-tempC
            sumF = tempC*2 + tempC
            
            if a == 0:
                print(sumF)
            else:
                
                tempB = b//2
                
                if tempB>=a:
                    print(sumF+a*2+a)
                else:
                    sumF = sumF + tempB * 2 + tempB
                    print(sumF)
                    
    t = t-1