s = input()
result = []
pos = 0
state = 0
for i in range(len(s)):
    if s[i] == '(':
        state += 1
    elif s[i] == ')':
        state -= 1
    elif s[i] == '#':
        x = max(1, state)
        state -= x
        result.append(x)

    if state < 0:
        while pos < len(result) and result[pos] <= 1:
            pos += 1
        if pos >= len(result):
            result = [-1]
            break
        result[pos] -= 1
        state += 1

if state > 0:
    result = [-1]

for r in result:
    print(r)
