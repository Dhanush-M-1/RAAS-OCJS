n = int(input())
s = list(input())

s2 = sorted(s)

aldict = {}
tmp = "abcdefghijklmnopqrstuvwxyz"
for i, c in enumerate(tmp):
    aldict[c] = i

if s == s2:
    print("No")
else:
    diffs = []
    count = 0
    i = 0

    c1 = None
    loop = True
    #print(s2)
    while loop:
        if s[i] != s2[i]:
            if count == 0: 
                c1 = s[i]
                val1 = aldict[c1]
                count += 1
                diffs.append(i)
        if count == 1 and val1 > aldict[s[i]]:
                diffs.append(i)
                loop = False
        i += 1
    print("Yes")
    print(" ".join([str(diff+1) for diff in diffs]))
        
        
