queries=int(input())
for x in range(queries):
    count=0
    stones=input()
    stones=stones.split()
    stones=[int(x) for x in stones]
    for x in range(max(stones)):
        if (stones[0]>0 and stones[1]>1) or (stones[1]>0 and stones[2]>1):
            count+=3
            if stones[1]>0 and stones[2]>1:
                stones[1]=stones[1]-1
                stones[2]=stones[2]-2
            else:
                stones[0]-=1
                stones[1]-=2
        else:
            break
    print(count)
    
            