import sys
input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
    n = int(input())
    tmp = n
    ans = 0
    three = 0
    flag = False

    while 1 < tmp:
        if tmp%6 == 0:
            tmp = tmp//6
            ans += 1
        else:
            while 1 < tmp:
                if tmp%3 == 0:
                    tmp = tmp//3
                    three += 1
                else:
                    flag = True
                    break
        
        if flag:
            break
    
    if flag:
        print(-1)
    else:
        print(ans + three*2)
