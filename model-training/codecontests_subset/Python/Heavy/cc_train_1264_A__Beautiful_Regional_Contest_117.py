for _  in range(int(input())):
    ln = int(input())
    a = [int(x) for x in input().split()]

    my_g = my_s = my_b = -1
    g = s = b = 0
    for i in range(ln):
        if my_g == -1:
            my_g = a[i]
        if a[i] == my_g:
            g += 1
        elif a[i] < my_g:
            if my_s == -1:
                my_s = a[i]
            if a[i] == my_s or s <= g:
                if a[i] <= my_s:
                    my_s = a[i]
                s += 1
            elif a[i] < my_s:
                if my_b == -1:
                    my_b = a[i]
                if a[i] <= my_b or b <= g:
                    if a[i] <= my_b:
                        my_b = a[i]
                    b += 1
                    if i == ln//2 - 1:
                        if a[i+1] != a[i]:
                            # print('break1')
                            break
                        else:
                            # print('minus', a[i], b)
                            b -= a[0:ln//2].count(a[i])
                            break

    # print(my_g, my_s, my_b)
    if g >= s or g >= b or g+s+b > ln//2 :
        print(0,0,0)
    else:
        print(g,s,b)

        

