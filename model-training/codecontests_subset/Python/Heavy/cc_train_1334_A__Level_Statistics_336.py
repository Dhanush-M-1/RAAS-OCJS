t = int(input())

for _ in range(t):
    n = int(input())
    s = []
    
    for i in range(n):
        s.append(list(map(int, input().split())))
        
    ok = True
    
    for i in range(n):
        for j in range(i, n):
            if s[i][0] == s[j][0] and s[i][1] != s[j][1]:
                ok = False
                break
            
            if s[i][1] > s[j][1]:
                ok = False
                break
                
            if s[i][0] > s[j][0]:
                ok = False
                break
                
            if s[i][0] < s[i][1] or s[j][0] < s[j][1]:
                ok = False
                break
            
            if s[j][0] - s[i][0] < s[j][1] - s[i][1]:
                ok = False
                break
                
        if not ok:
            break
            
    if ok:
        print("YES")
    else:
        print("NO")