kl = int(input())
for kt in range(kl):
    s, s1 = [str(i) for i in input().split()]
    mn = []

    for j in range(0, len(s)):
        mx = s[j]
        for i in range(j, len(s)):
            if s[i] < mx:
                mx = s[i]
                it = i
        if mx != s[j]:
            mn += [j]
            mn += [s.rfind(s[it])]
            break
    if mn != []:

        s2 = s[:mn[0]] + s[mn[1]] + s[mn[0] + 1:mn[1]] + s[mn[0]] + s[mn[1] + 1:]


    else:
        s2 = s

    s2 += '1'
    s1 += '1'
    pr = 1
    for i in range(len(s2)):
        if s2[i] < s1[i]:
            pr = 0
            print(s2[:len(s2) - 1])
            break
        if s2[i] > s1[i]:
            pr = 0
            print('---')
            break
    if pr:
        print('---')
