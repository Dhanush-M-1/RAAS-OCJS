for _ in range(int(input())):
    n = int(input())
    moves = 0
    while True:
        if n%6==0:
            moves+=1
            n = n//6
        elif n==1:
            print(moves)
            break
        elif n<6:
            if n==3:
                n = 2*n
                moves+=1
            else:
                print(-1)
                break
        else:
            if (2*n)%6==0:
                moves+=1
                n = 2*n
            else:
                print(-1)
                break
        
