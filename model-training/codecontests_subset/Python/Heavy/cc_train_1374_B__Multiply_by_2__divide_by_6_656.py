import math
T = int(input())
for _ in range(0,T):
    n = int(input())
    cnt2 = 0
    cnt3 = 0
    if n == 1:
        print(0)
        continue
    else:
        while(n%2==0):
            cnt2+=1
            n = n//2
        while(n%3==0):
            cnt3 += 1
            n = n//3
        if(n != 1):
            print(-1)
            continue
        else:
            if cnt2>cnt3:
                print(-1)
                continue
            else:
                print(cnt2+(cnt3-cnt2)*2)
                continue