s = input()
left_paranthesis = sum(i == '(' for i in s)
right_paranthesis = sum(i == ')' for i in s)
hashes = sum(i == '#' for i in s)
if left_paranthesis < right_paranthesis + hashes:
    print(-1)
    exit()
elif left_paranthesis == right_paranthesis + hashes:
    s.replace('#', ')')
    lp = 0
    rp = 0
    for i in s:
        if i == '(':
            lp += 1
        else:
            rp += 1
        if rp > lp:
            print(-1)
            exit()
    for i in range(hashes):
        print(1)
else:
    excess = left_paranthesis - right_paranthesis - hashes + 1
    l = s.rfind('#')
    ans = []
    for i, j in enumerate(s):
        if j != '#':
            ans.append(j)
        elif i != l:
            ans.append(')')
        else:
            ans.append(')' * excess)
    ans = ''.join(ans)
    lp = 0
    rp = 0
    for i in ans:
        if i == '(':
            lp += 1
        else:
            rp += 1
        if rp > lp:
            print(-1)
            exit()
    for i in range(hashes - 1):
        print(1)
    print(excess)

