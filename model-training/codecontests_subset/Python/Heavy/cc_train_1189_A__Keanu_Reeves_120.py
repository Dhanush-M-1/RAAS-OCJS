n = int(input())
s = input()

cnt_1 = 0
cnt_0 = 0
for i in range(n):
    if s[i] == "1":
        cnt_1 += 1
    elif s[i] == "0":
        cnt_0 += 1

if cnt_1 != cnt_0:
    print(1)
    print(s)
    exit()
else:
    for i in range(n):
        cnt_l1 = 0
        cnt_l0 = 0
        cnt_r1 = 0
        cnt_r0 = 0
        for j in range(n):
            if j < i:
                if s[j] == "1":
                    cnt_l1 += 1
                else:
                    cnt_l0 += 1
            else:
                if s[j] == "1":
                    cnt_r1 += 1
                else:
                    cnt_r0 += 1
        if cnt_l1 != cnt_l0 and cnt_r1 != cnt_r0:
            print(2)
            print(s[0:j], s[j:])
            exit()
