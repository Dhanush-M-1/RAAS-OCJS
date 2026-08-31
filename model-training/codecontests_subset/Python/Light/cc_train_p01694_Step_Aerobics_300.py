while True:
    c = 0
    ans = 0
    a = int(input())
    left = 0
    right = 0
    if a == 0:
        break
    b = input()
    b = b.split(" ")
    for i in b:
        if i == "lu":
            left = 1
        elif i == "ru":
            right = 1
        elif i == "rd":
            right = 0
        elif i == "ld":
            left = 0
        if left == right:
            if before[0] != i[0]:
                ans = ans + 1
        c = c + 1
        before = i
    print(ans)
    
