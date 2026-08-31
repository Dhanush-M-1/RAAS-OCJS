n,p,w,d = list(map(int, input().split()))
W = p//w
flag = 0
for i in range(min(W+1,1000000)):
    win_cost  = i*w
    draw_cost = p - win_cost
    if draw_cost%d == 0:
        if (draw_cost//d + i) <= n:
            flag = 1
            print(i, draw_cost//d, n-(i + draw_cost//d))
            break
D = p//d
if flag == 0:
    for i in range(min(D+1,1000000)):
        draw_cost  = i*d
        win_cost = p - draw_cost
        if win_cost%w == 0:
            if (win_cost//w + i) <= n:
                flag = 1
                print(win_cost//w,i , n-(i + win_cost//w))
                break
    if flag == 0:
        print(-1)

