from math import log
t = int(input())

for _ in range(t):
    n = int(input())
    if n ==1:
        print(0)
    else:
        moves = 0
        increase = 0
        while True:
            if n%6==0:
                n = n//6
                increase-=1
            else:
                n = n*2
                increase+=1
            
            moves+=1
            if increase >=30:
                print(-1)
                break

            if n==1:
                print(moves)
                break

