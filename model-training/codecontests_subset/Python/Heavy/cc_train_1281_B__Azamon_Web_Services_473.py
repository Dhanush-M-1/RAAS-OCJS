for _ in range(int(input())):
    s, c = map(list, input().split())
    cond = False
    for i in range(len(s)):
        m = ord(s[i])
        index = -1
        for j in range(i+1, len(s)):
            if m > ord(s[j]):
                m = ord(s[j])
                index = j
            elif m == ord(s[j]) and ord(s[j]) < ord(s[i]):
                index = j
        if index != -1:
            temp = s[index]
            s[index] = s[i]
            s[i] = temp
            break
    result = False
    cnt = 0
    for i in range(min(len(s), len(c))):
        if s[i] == c[i]:
            cnt += 1
            continue
        if s[i] > c[i]:
            break
        result = True
        break
    if cnt == len(s) and len(s) < len(c):
        print(''.join(s))
    elif result:
        print(''.join(s))
    else:
        print("---")