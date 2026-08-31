t = int(input())
a = []
crnt = ''
if t == 0:
    print(0)
else:
    for i in range(0, t):
        b = []
        s = input()
        #print(s)
        if s[-1] != ' ':
            s += ' '
        crnt = ''
        for j in range(0, len(s)):
            if s[j] == ' ':
                b += [int(crnt)]
                crnt = ''
                continue
            crnt += s[j]
        a.append(b)
        
for i in range(0, t):
    if a[i][2] % 3 == 0:
        print(a[i][0])
    if a[i][2] % 3 == 1:
        print(a[i][1])
    if a[i][2] % 3 == 2:
        print(a[i][0] ^ a[i][1])
         