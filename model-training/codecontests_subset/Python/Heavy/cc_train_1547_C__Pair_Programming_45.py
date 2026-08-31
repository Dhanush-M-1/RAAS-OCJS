tt = int(input())



for _ in range(tt):
    empt=input()
    k,n,m=list(map(int, input().split(' ')))
    ai=list(map(int, input().split(' ')))
    bi=list(map(int, input().split(' ')))

    numlines=k
    ans=[]
    for i in range(n+m):
        am=ai[0] if (ai) else -1
        bm=bi[0] if (bi) else -1

        if(am>0 and am<=numlines):
            ans.append(str(am))
            ai=ai[1:]
        elif(bm>0 and bm<=numlines):
            ans.append(str(bm))
            bi=bi[1:]
        elif(am==0):
            numlines+=1
            ans.append(str(am))
            ai=ai[1:]
        elif(bm==0):
            numlines+=1
            ans.append(str(bm))
            bi=bi[1:]
        else:
            ans=[-1]
            break
    print(*ans, sep=' ')