for i in range(int(input())):
    n = int(input())
    plays_old, clears_old = list(map(int, input().split()))
    x = 0
    if plays_old < clears_old:
        x = 1
        for k in range(n-1):
            input()
    else:
        for j in range(n-1):
            plays_new, clears_new = list(map(int, input().split()))
            if (clears_new - clears_old) < 0 or(plays_new - plays_old) < (clears_new - clears_old):
                x = 1
                for k  in range(n-2-j):
                    input()
                break
            plays_old = plays_new
            clears_old = clears_new
    if x == 1:
        print('NO')
    else:
        print('YES')
        
                