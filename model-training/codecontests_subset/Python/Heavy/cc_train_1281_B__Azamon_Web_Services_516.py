t = int(input())
answers = []
for ti in range(t):
    inp = input().split()
    s = (inp[0])
    c = (inp[1])

    if s < c:
        answers.append(s)
        continue

    s = list(inp[0])
    s_sorted = s.copy()
    s_sorted.sort()

    c = list(inp[1])

    for i in range(len(s)):
        if s[i] > s_sorted[i]:
            pos = 0
            for j in range(i + 1, len(s)):
                if s[j] == s_sorted[i]:
                   pos = j
            if pos != 0:
                char = s[i]
                s[i] = s_sorted[i]
                s[pos] = char
                break

    if s < c:
        answers.append(''.join(s))
    else:
        answers.append("---")

for a in answers:
    print(a)
