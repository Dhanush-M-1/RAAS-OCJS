def f(x):
    m = x
    cnt2 = 0
    cnt3 = 0
    while True:
        if m % 2 == 0:
            cnt2 = cnt2 + 1
            m = m // 2
        else:
            if m % 3 == 0:
                cnt3 = cnt3 + 1
                m = m // 3
            else:
                if m > 1:
                    return -1
                else:
                    if cnt3 >= cnt2:
                        return 2 * cnt3 - cnt2
                    else:
                        return -1
t = int(input())
for i in range(0, t):
    x = int(input())
    print(f(x))
                
