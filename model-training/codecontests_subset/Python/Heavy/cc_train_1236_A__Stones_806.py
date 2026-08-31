t = int(input())
answers = list()
l = 0
while (l < t) :
    heaps = input()
    heaps = heaps.split()
    i = 0
    while(i < 3) :
        heaps[i] = int(heaps[i])
        i = i + 1

    result1 = 0
    result2 = 0

    if ( int((heaps[1]/2)) >= heaps[0] ) :
        result1 = result1 + int(heaps[0])*3
        remain_heap_2 = heaps[1]- int(heaps[0]*2)
        remain_heap_3 = heaps[2]
        while( (remain_heap_2 >= 1) and (remain_heap_3 >= 2) ) :
            result1 = result1 + 3
            remain_heap_2 = remain_heap_2 - 1
            remain_heap_3 = remain_heap_3 - 2
    else :
        result1 = result1 + int(heaps[1]/2) * 3
        if ( (heaps[1]/2)%1 != 0 ) and (heaps[2] >= 2) :
            result1 = result1 + 3

    if ( int((heaps[2]/2)) >= heaps[1] ) :
        result2 = heaps[1]*3
    else :
        result2 = 3*int((heaps[2]/2))
        remain_heap_2 = heaps[1] - int(heaps[2]/2)
        remain_heap_1 = heaps[0]
        while (remain_heap_1 >= 1) and (remain_heap_2 >=2) :
            result2 = result2 + 3
            remain_heap_1 = remain_heap_1 - 1
            remain_heap_2 = remain_heap_2 - 2

    if (result1 >= result2) :
        answers.append(result1)
    else :
        answers.append(result2)

    l = l + 1

l = 0
while (l<t) :
    print(answers[l])
    l = l + 1
