s = input()
w = [input() for k in range(int(input()))]

poss = False
for a in w:
    if (a == s):
        poss = True
        break
    
    for b in w:
        if a[1] + b[0] == s:
            poss = True
            break

if poss:
    print('YES')
else:
    print('NO')
