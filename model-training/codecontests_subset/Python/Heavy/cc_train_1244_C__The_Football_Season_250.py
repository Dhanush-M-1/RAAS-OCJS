inp = [int(x) for x in input().split()]
n = inp[0]
p = inp[1]
w = inp[2]
d = inp[3]
if p == 0:
    print(0,0,n)
    exit(0)

# n_temp = n
# mi = p + 1

p_temp = p
sum_w = 0
ans_x = 0
ans_y = 0
ans_z = 0

found = False
osztok = {}

while p_temp > 0:
    if p_temp % w != 0:
        if (p_temp%w) in osztok:
            break
        osztok[p_temp%w] = 1
        p_temp -= d
        ans_y += 1
    else:
        found = True
        break

# print(osztok)

# while (p_temp - w)> -1:
#     sum_w += 1
#     if (p_temp - w) % d == 0:
#         # print(p_temp - w)
#         mi = p_temp - w
#         ans_x = sum_w 
#     p_temp -= w


# if mi != (p + 1):
# print(ans_y, p)
if found:
    # ans_y = p - (ans_x * w)
    ans_x = p_temp // w
    ans_z = n - ans_x - ans_y
    if ans_x + ans_y > n :
        # print(ans_x, ans_y)
        print(-1)
        exit(0)
elif p % d == 0:
    ans_y = p // d
    ans_z = n - ans_y
    if ans_y <= n:
        print(ans_x, ans_y, ans_z)
        exit(0)        
else:
    print(-1)
    exit(0)

if ans_x * w + ans_y * d == p:
    print(ans_x, ans_y, ans_z)
else:
    print(-1)

