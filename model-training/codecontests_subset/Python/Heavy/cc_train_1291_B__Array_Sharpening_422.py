import sys

t = int(sys.stdin.readline().rstrip())
for _ in range(t): 
    n = int(sys.stdin.readline().rstrip())
    s = list(map(int,sys.stdin.readline().rstrip().split(' ')))
    cress = True
    prev = -1
    counter = 0
    for num in s:
        counter +=1
        if cress and num > prev:
            prev = num
        elif cress and num < prev:
            if num >= counter-1:
                prev = num
            else:
                cress = False
                prev = num
        elif cress and num == prev:
            if num >= counter-1:
                prev = num
            else:
                cress = False
                prev = num-1
        elif not cress:
            if num == prev:
                prev = num-1
            else:
                prev = num

        
        if not cress:
            if (n-counter)>prev:
                print('No')
                break
    else:
        print('Yes')
            





 
