n1=int(input())
for test in range (n1):
    n = int(input())
    set1=[int(y) for y in input().split()]
    m=set1[0]+set1[1]
    booli = False
    track=0
    for i in range(2,n):
        if(set1[i]>=m):
            track=i+1
            break

    if(track!=0):
        print("1 "+"2 "+str(track))

    else:
        print(-1)
            
            
        
