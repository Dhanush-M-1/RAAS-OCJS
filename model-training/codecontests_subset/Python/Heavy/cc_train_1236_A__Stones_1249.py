tests = int(input())
for i in range(tests):
    heaps = list(map(int, input().split()))
    heap00 = heap10 = heaps[0]
    heap01 = heap11 = heaps[1]
    heap02 = heap12 = heaps[2]
    stones = []
    stone = 0
    # starting from right
    if (heap01 != 0):
        k = heap01//2
        if(k <= heap00 and heap00):
            heap00 -= k
            heap01 -= k*2
            stone += k*3
            if(heap01 != 0 and heap02>=2):
                stone += 3
            stones.append(stone)
        else:
            heap01 -= heap00*2
            stone += heap00*3
            k = heap02//2
            if(k <= heap01):
                stone += k*3
            else:
                stone += heap01*3
            stones.append(stone)
            
    else:
        stones.append(0)
    # end
    
    # starting from left
    stone = 0
    if (heap11 != 0):
        k = heap12//2
        if(k <= heap11 and heap11):
            heap11 -= k
            heap12 -= k*2
            stone += k*3
            if(heap11 != 0 and heap10 >= 2):
                k = heap11//2
                if(k <= heap10):
                    stone += k*3
            stones.append(stone)
        else:
            stone += heap11*3
            stones.append(stone)
            
    else:
        stones.append(0)
    # end
    

    print(max(stones)) 






