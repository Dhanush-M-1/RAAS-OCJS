for _ in range(int(input())):
    s1, s2 = input().split()

    if s1 < s2:
        print(s1)
        continue

    di = [0]*26 + [1]
    for i in s1:
        di[ord(i.upper()) - 65] += 1

    cur_i = 0
    for i in range(26):
        if di[i] > 0:
            cur_i = i
            break

    s11 = ""
    alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    ind = 0
    for j in range(len(s1)):
        i = s1[j]
        if i == alphabets[cur_i]:
            di[cur_i] -= 1
            if di[cur_i] == 0:
                for x in range(cur_i, 27):
                    if di[x] > 0:
                        cur_i = x
                        break
        else:
            ind = j
            break

    s1 = list(s1)
    s11 = "Z"*6000
    for i in range(ind+1, len(s1)):
        s1copy = list(s1)
        s1copy[i], s1copy[ind] = s1copy[ind], s1copy[i]
        s11 = min(s11, "".join(s1copy))


    if s11 >= s2:
        print("---")
    else:
        print(s11)