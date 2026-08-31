for u in range(int(input())):
    n = int(input())
    x = [int(w) for w in input().split()]
    
    if x[0] + x[1] > x[-1]:
        print(-1)
        
    else:
        print(1, 2, n)