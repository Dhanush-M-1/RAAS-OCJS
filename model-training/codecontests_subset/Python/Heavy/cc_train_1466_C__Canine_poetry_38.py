from collections import Counter
for _ in range(int(input())):
    s = input()
    d = Counter(s)
    n = len(s)
    ans = 0
    vis = {}
    for i in range(n):
        vis[i] = 0
    i = 0
    while(i+1 < n):
        if(vis[i] == 1):
            i+=1 
            continue
        elif(i + 2 < n and s[i] == s[i+1] and s[i] == s[i+2]):
            ans += 2
            i += 2
        elif(s[i] == s[i+1]):
            ans += 1
            i+=1
        elif(i+2 < n and s[i] == s[i+2]):
            ans += 1
            vis[i+2] = 1
        i += 1
    print(ans)