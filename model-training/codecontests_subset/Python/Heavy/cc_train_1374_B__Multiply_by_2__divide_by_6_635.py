t=int(input())

while t:
    n=int(input())
    
    a=0
    b=0
    while(n%2==0):
        a+=1
        n=n//2
 
    while (n%3==0):
        b+=1
        n=n//3
 
    if n==1:
        
        if a>b:
            print(-1)
 
        else:
            x = abs(b-a)
            print(max(b,a) + x)
    else:
        print(-1)
    
    t-=1
 

##for i in range(n):
##    currentTestcase = int(input())
##    counter = 0
##    appended = False
##    if currentTestcase == 1:
##        output.append(0)
##        appended = True
##    elif currentTestcase % 3 != 0:
##        output.append(-1)
##        appended = True
##    while appended == False:
##        counter += 1
##        if currentTestcase % 2 == 0 and currentTestcase % 3 != 0:
##            appended = True
##            output.append(-1)
##            break
##        elif currentTestcase % 6 == 0:
##            currentTestcase = currentTestcase//6
##            if currentTestcase == 1:
##                break
##            else:
##                continue
##        elif currentTestcase % 2 != 0 and currentTestcase % 3 == 0:
##            currentTestcase = currentTestcase * 2
##            continue
##        elif currentTestcase % 2 != 0 and currentTestcase % 3 != 0:
##            appended = True
##            output.append(-1)
##    if counter != 0 and appended == False:
##        output.append(counter)
##for i in output:
##    print(i)
