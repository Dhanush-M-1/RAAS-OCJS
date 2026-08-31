t = int(input())
for i in range(t):
    answer = 0
    n = int(input())
    s = list(input())
    if s[0] == '<' and s[-1] == '>':
        c = 0
        b = 0
        for l in range(len(s)-1):
            if s[l] == s[l+1]:
                b += 1
            else:
                break
        for z in range(1, len(s)):
            if s[-z] == s[-z-1]:
                c += 1
            else:
                break
        print(min(c,b) + 1)
    else:
        for k in range(1,len(s)):
            if (len(set(s[0:k])) == 1) and (s[0:k][0] == '<') and (len(set(s[k:len(s)])) == 1) and (s[k:len(s)][0] == '>'):
                answer = min(len(s[0:k]), len(s[k:len(s)]))
        print(answer)



