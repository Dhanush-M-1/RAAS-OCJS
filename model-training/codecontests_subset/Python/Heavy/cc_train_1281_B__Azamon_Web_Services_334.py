for t in range(int(input())):
    s1, s2 = input().split()
    if s1 < s2:
        print(s1)
        continue
    found = False
    i = 0
    for i in range(min(len(s1), len(s2))):
        if s2[i] != s1[i]:
            found = True
            break
    flag = False
    (mex, index) = (s1[0], 0)
    for k in range(1, i + 1):
        if s1[k] < s1[k - 1]:
            print(s1[:k - 1] + s1[k] + s1[k - 1] + s1[k + 1:])
            flag = True
            break
        elif k < i:
            (mex, index) = (s1[k], k)
    if not flag:
        for j, c in enumerate(s1[i:], start=i):
            if c < mex and i != 0:
                print(s1[:index] + c + s1[index + 1:j] + mex + s1[j + 1:])
                flag = True
                break
            if c <= s2[i]:
                if (s1[:i] + c + s1[i + 1:j] + s1[i] + s1[j + 1:]) < s2:
                    print(s1[:i] + c + s1[i + 1:j] + s1[i] + s1[j + 1:])
                    flag = True
                    break
    if not flag:
        print('---')
