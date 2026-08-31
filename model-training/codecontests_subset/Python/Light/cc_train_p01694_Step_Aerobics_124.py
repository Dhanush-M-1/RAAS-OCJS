while True:
    n = int(input())
    if n == 0:
        break
    f = list(input().split())
    
    is_on = False
    left_up = False
    right_up = False
    ans = 0
    for i in range(n):
        if f[i] == "lu":
            left_up = True
        elif f[i] == "ld":
            left_up = False
        elif f[i] == "ru":
            right_up = True
        else:
            right_up = False
        
        if left_up and right_up and not is_on:
            is_on = True
            ans += 1
        elif not left_up and not right_up and is_on:
            is_on = False
            ans += 1
    print(ans)
