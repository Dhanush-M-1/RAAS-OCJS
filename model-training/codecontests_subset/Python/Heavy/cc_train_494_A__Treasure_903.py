s = input()
opening = 0
closing = 0
all_symbols = []
last_empty = -1
for i in range(len(s)):
    ch = s[i]
    if ch == '(':
        opening += 1
    elif ch == ')':
        closing += 1
    else:
        last_empty = i
    all_symbols.append(ch)
if len(s) - opening - closing > opening - closing or (last_empty == -1 and opening != closing):
    print(-1)
else:
    ans = []
    k = opening - closing
    cnt = 0
    for i in range(len(s)):
        ch = all_symbols[i]
        if ch == '#':
            if i == last_empty:
                ans.append(k)
                cnt -= k
            else:
                ans.append(1)
                k -= 1
                cnt -= 1
        elif ch == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt < 0:
            print(-1)
            exit()
    if cnt != 0:
        print(-1)
    else:
        for elem in ans:
            print(elem)
