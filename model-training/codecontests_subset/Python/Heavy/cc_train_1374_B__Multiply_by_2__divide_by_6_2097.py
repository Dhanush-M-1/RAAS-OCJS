t = int(input())



while t:
    n = int(input())
    if n == 1:
        print(0)
        t-=1
        continue
    twoes = 0
    threes = 0
    while n%2 == 0:
        twoes+=1
        n//=2
    while n%3 == 0:
        threes+=1
        n//=3
        
    if n!=1:
        print(-1)
    else:
        if threes == 0:
            print(-1)
        elif twoes == 0:
            print(2*threes)
        else:
            if threes>twoes:
                print(twoes+2*(threes-twoes))
            elif threes == twoes:
                print(threes)
            else:
                print(-1)
        
    
    t-=1