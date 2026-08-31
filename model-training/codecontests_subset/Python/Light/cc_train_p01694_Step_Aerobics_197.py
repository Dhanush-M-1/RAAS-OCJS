if __name__ == "__main__":
    while 1:
        n = int(input())
        if n == 0:break
        line = input().strip().split()
        lstate = 0 # floor = 0 ,upstairs = 1
        rstate = 0
        flag = 0#floor =0???????????°flag = 0
        ans =0
        for l in line:
            if lstate and not flag and l == 'ru':
                ans +=1
                flag = 1
            elif rstate and not flag and l =='lu':
                ans +=1
                flag = 1
            elif not rstate and flag and l == 'ld':
                ans +=1
                flag = 0
            elif not lstate and  flag and l == 'rd':
                ans +=1
                flag = 0

            if l =='lu':lstate=1
            if l =='ru':rstate=1
            if l == 'ld': lstate = 0
            if l == 'rd': rstate = 0
        print(ans)