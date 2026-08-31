for _ in range(int(input())):
    n = int(input())
    points = list(map(int, input().split()))
    count = []
    prev = -1
    for i in range(n):
        if points[i] == prev:
            count[-1] += 1
        else:
            count.append(1)
        prev = points[i]
    
    m = 0
    tot = 0
    while tot + count[m] <= n//2:
        tot += count[m]
        m += 1
    
    # <= tot people get a medal, up to index m-1
    fail = False
    gold, silv, bron = 0,0,0
    if m < 3: 
        fail = True
    else:
        gold = count[0]
        silv = count[1]
        j = 1
        while (gold >= silv and j+1<m):
            j += 1
            silv += count[j]
        
        bron = sum(count[j+1:m])
        if gold >= silv or gold >= bron:
            fail = True
    if fail:
        print("0 0 0")
    else:
        print(gold,silv,bron)
    
