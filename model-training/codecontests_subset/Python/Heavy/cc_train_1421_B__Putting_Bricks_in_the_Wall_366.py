
for _ in range(int(input())):
    
    n = int(input())
    
    s = [input() for i in range(n)]
    
    ans = []
    
    if s[0][2] == s[1][1] == s[2][0]:
        
        if s[0][1] == s[0][2]:
            ans += ['1 2']
            
        if s[1][0] == s[0][2]:
            ans += ['2 1']
            
    else:
        x = 0
        if s[0][1] != s[1][0]:
            
            if s[0][2] == s[1][1]:
                ans += ['3 1']
            
            elif s[0][2] == s[2][0]:
                ans += ['2 2']
            
            else:
                ans += ['1 3']
                x = 1
            
            if x == 0:
                
                if s[0][2] == s[0][1]:
                    ans += ['1 2']
                
                else:
                    ans += ['2 1']
            
            else:
                
                if s[1][1] == s[0][1]:
                    ans += ['1 2']
                    
                else:
                    ans += ['2 1']
                    
            
        else:
            
            if s[0][2] == s[0][1]:
                
                ans += ['1 3']
                
            if s[1][1] == s[0][1]:
                
                ans += ['2 2']
                
            if s[2][0] == s[0][1]:
                
                ans += ['3 1']
    
    print(len(ans))
    
    for a in ans:
        
        print(a)
            
            