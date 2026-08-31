
def helpPolikarp():
    isReal = True
    
    statList =[]
    answersList =[]
    T = int(input())
    for i in range(T):
        
        n = int(input())
        for j in range(n):
            plays, clears = map(int, input().split())
            statList.append([plays,clears])
            if (clears > plays):
                isReal = False
            
        firstTries = statList[0][0]
      #  print("firsttr = ", firstTries)
        firstClears = statList[0][1]
      #  print("firstcre = ", firstClears)
        deltaC = 0
        deltaP = 0
        for z in statList:
            deltaP = z[0] - firstTries
            deltaC = z[1] - firstClears
            if (z[0] > firstTries):
                
                firstTries = z[0]
                
           #     print("firsttr is changed = ", firstTries)
            if(z[1] > firstClears):
                
                firstClears = z[1]
            #    print("firstclr is changed = ", firstClears)
            if (z[0] < firstTries or z[1] < firstClears or deltaC > deltaP):
                isReal = False
        statList.clear()
        answersList.append("YES" if isReal else "NO")
        isReal = True
    for answer in answersList:
        print(answer)
helpPolikarp()
