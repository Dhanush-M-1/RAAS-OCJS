ans = []

while True:
    n = int(input())
    
    if n == 0:
        break

    l_step, r_step = 0, 0
    flag = False
    step = input().split()
    cnt = 0
    for i in range(n):
        
        if step[i] == "lu":
            l_step = 1
        elif step[i] == "ru": 
            r_step = 1
        elif step[i] == "ld":
            l_step = 0
        elif step[i] == "rd":
            r_step= 0

        if flag == False:
            if l_step + r_step == 2:
                cnt += 1
                flag = True

        else:
            if l_step + r_step == 0:
                cnt += 1
                flag = False

    ans.append(cnt)

for i in ans:
    print(i)

