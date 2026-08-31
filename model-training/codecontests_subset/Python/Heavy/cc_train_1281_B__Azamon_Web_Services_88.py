alphabet_large = {chr(i):i-65 for i in range(65, 65+26)} #大文字
t = int(input())
for _ in range(t):
    s,c =input().split()
    l = len(s)
    t = False
    for i in range(26):
        for j,x in enumerate(s[::-1]):
            if alphabet_large[x] == i:
                #print("x:" + x + str(j))
                for k,y in enumerate(s[:l-j-1]):
                    if alphabet_large[y] > i:

                        s = s[:k] + x + s[k+1:l-j-1] + y + s[l-j:]

                        t = True
                        break
            if t:
                break
        if t:
            break
    now = 0
    #print(s)
    while now < min(len(s),len(c)):
        if alphabet_large[s[now]] < alphabet_large[c[now]]:
            print(s)
            break
        elif alphabet_large[s[now]] > alphabet_large[c[now]]:
            print("---")
            break
        else:
            now += 1
    if now == min(len(s),len(c)):
        if len(s) < len(c):
            print(s)
        else:
            print("---")