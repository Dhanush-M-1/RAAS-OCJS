#607_B

n = int(input())

for i in range(0, n):
    ln = input().split(" ")
    s1 = ln[0]
    s2 = ln[1]

    inds = [-1] * 26

    for j in range(0, len(s1)):
        #if inds[ord(s1[j]) - 65] == -1:
        inds[ord(s1[j]) - 65] = j

    for j in range(0, len(s1)):
        o = ord(s1[j]) - 65
        repl = False
        for k in range(o - 1, -1, -1):
            if inds[k] > j:
                repl = [j, inds[k]]

        if repl:
            s1 = list(s1)
            os = s1[repl[0]]
            s1[repl[0]] = s1[repl[1]]
            s1[repl[1]] = os
            s1 = "".join(s1)
            break

    f = True

    for j in range(0, len(s1)):
        if j >= len(s2):
            f = False
            break
        if s1[j] == s2[j]:
            continue
        if ord(s1[j]) > ord(s2[j]):
            f = False
            break
        if ord(s1[j]) < ord(s2[j]):
            break

    if f and s1 != s2:
        print(s1)
    else:
        print("---")
