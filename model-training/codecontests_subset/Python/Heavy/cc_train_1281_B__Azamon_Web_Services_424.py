
let = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
ldic = {}

for i in range(26):
    ldic[let[i]] = i

#print (ldic)

t = int(input())

for loop in range(t):

    s,c = input().split()
    s = list(s)
    c = list(c)

    ss = s.copy()
    ss.sort()

    use = False
    for i in range(len(s)):
        if s[i] != ss[i]:

            for j in range(len(s)):
                j = len(s)-1-j
                if s[j] == ss[i] and j > i:
                    s[j] = s[i]
                    s[i] = ss[i]
                    use = True
                    break
        if use:
            break
            
  
    flag = 0
    for i in range(min(len(s) , len(c))):
        if ldic[s[i]] > ldic[c[i]]:
            flag = -1
            break
        elif ldic[s[i]] < ldic[c[i]]:
            flag = 1
            break

    if flag == 1 or (flag == 0 and len(s) < len(c)):
        print ("".join(s))
    else:
        print ("---")
        
