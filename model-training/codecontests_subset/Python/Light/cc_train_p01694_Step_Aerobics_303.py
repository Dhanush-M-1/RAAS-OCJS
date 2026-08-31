while True :
    n = int(input())
    if n == 0 :
        break
    
    posi = 0
    right = 0
    left = 0
    cnt = 0
    task = list(input().split())
    for i in range(n) :
        if task[i] == 'lu' :
            left = 1
        elif task[i] == 'ru' :
            right = 1
        elif task[i] == 'ld' :
            left = 0
        elif task[i] == 'rd' :
            right = 0
        if posi == 0 and right == 1 and left == 1 :
            cnt += 1
            posi = 1
        elif posi == 1 and right == 0 and left == 0 :
            cnt += 1
            posi = 0
    print(cnt)
