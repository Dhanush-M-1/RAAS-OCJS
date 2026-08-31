n = int(input())
st = input()

mid = int(n / 2)

count0_l = 0
count1_l = 0
count0_r = 0
count1_r = 0

if n == 1:
    print(1)
    print(st)
    exit()

for i in range(mid):
    if st[i] == '0':
        count0_l += 1
    else:
        count1_l += 1

for i in range(mid, n):
    if st[i] == '0':
        count0_r += 1
    else:
        count1_r += 1

tmp = mid
if count0_l + count0_r == count1_l + count1_r:
    if count0_l != count1_l and count1_r != count0_r:
        print(2)
        print(st[:tmp] + " " + st[tmp:n])
        exit()

    while tmp != n:
        if st[tmp] == '0':
            count0_l += 1
            count0_r -= 1
        else:
            count1_l += 1
            count1_r -= 1
        tmp += 1
        if count0_l != count1_l and count1_r != count0_r:
            print(2)
            print(st[:tmp] + " " + st[tmp:n])
            exit()
    tmp = mid
    while tmp >= 0:
        if st[tmp] == '0':
            count0_l -= 1
            count0_r += 1
        else:
            count1_l -= 1
            count1_r += 1
        tmp += 1
        if count0_l != count1_l and count1_r != count0_r:
            print(2)
            print(st[:tmp] + " " + st[tmp:n])
            exit()

print(1)
print(st)