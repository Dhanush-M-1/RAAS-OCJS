from collections import defaultdict
t = int(input())
while(t):
    dic = defaultdict(lambda:0)
    t = t-1
    s,c = input().split()
    s = list(s)
    c = list(c)
    for i in range(len(s)):
        dic[s[i]] = max(dic[s[i]],i)
    s1 = s[:]
    s1.sort()
    ind = -1
    for i in range(len(s)):
        if s1[i]!=s[i]:
            ind = i
            break
    if ind!=-1:
        s[ind],s[dic[s1[ind]]] = s[dic[s1[ind]]],s[ind]
    if s<c:
        a = ''
        for i in s:
            a+=i
        print(a)
    else:
        print("---")