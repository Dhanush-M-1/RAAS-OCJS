t = int(input())
for _ in range(t):
    s, c = input().split()
    s = list(s)
    c = list(c)
    last_occurrence = [-1 for i in range(26)]
    for i in range(len(s)):
        current_char_ord = ord(s[i]) - ord('A')
        last_occurrence[current_char_ord] = max(last_occurrence[current_char_ord], i)
    done = False
    for i in range(len(s)):
        for char_less_than_s_i in range(ord(s[i]) - ord('A')):
            if last_occurrence[char_less_than_s_i] > i:
                s[i], s[last_occurrence[char_less_than_s_i]] = s[last_occurrence[char_less_than_s_i]], s[i]
                done = True
                break
        if done:
            break
    i = 0
    while i < len(s) and i < len(c):
        if s[i] == c[i]:
            i += 1
        elif s[i] < c[i]:
            print(''.join(s))
            break
        else:
            print('---')
            break
    if i == len(c):
        print('---')
    elif i == len(s):
        print(''.join(s))

