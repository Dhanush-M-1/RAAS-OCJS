while 1:
    n=int(input())
    if not n:break
    l=input().split()
    pos=[0,0]
    isdown=True
    score=0

    for i in l:
        if i=="lu" and pos[0]==0:pos[0]+=1
        elif i=="ru" and pos[1]==0:pos[1]+=1
        elif i=="ld" and pos[0]>0:pos[0]-=1
        elif i=="rd" and pos[1]>0:pos[1]-=1
    
        if isdown and pos==[1,1]:
            isdown=False
            score+=1
        elif not isdown and pos==[0,0]:
            isdown=True
            score+=1    
    print(score)

