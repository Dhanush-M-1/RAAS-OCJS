import sys
r_input = sys.stdin.readline

t = int(r_input())

for _ in range(t):
    s1, s2 = r_input().rstrip().split()
    l_s1 = list(s1)
    l_s2 = list(s2)

    if s1 < s2:
        print(s1)
        continue

    cons1 = {chr(ch): [] for ch in range(65, 91)}
    cons2 = {chr(ch): [] for ch in range(65, 91)}

    for i, c in enumerate(s1):
        cons1[c].append(i)
    for i, c in enumerate(s2):
        cons2[c].append(i)

    length1 = len(s1)
    length2 = len(s2)

    flag = 0
    for i in range(min(length1, length2)):
        if s1[i] >= s2[i]:
            for c in range(65, ord(s1[i])):
                for n in cons1[chr(c)]:
                    if n > i:
                        l_s1[i], l_s1[n] = l_s1[n], l_s1[i]
                        if l_s1 < l_s2:
                            flag = 1
                            break
                        else:
                            l_s1[i], l_s1[n] = l_s1[n], l_s1[i]
                if flag:
                    break
            if flag or s1[i] > s2[i]:
                break


    print(''.join(l_s1) if flag else '---')
