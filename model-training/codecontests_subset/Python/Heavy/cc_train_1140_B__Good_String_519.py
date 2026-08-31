

n=int(input())

for i in range(n):
    s = int(input())
    
    S =input()
    if S.count('<') == s or S.count('>') == s:
        print(0)
        continue
    
    else:
        x1=S.index('<')
        y1=S.index('>')
        x2,y2=None,None
        ct = len(S) - 1
        while ct >= 0:
            if S[ct] == '>' and not y2:
                y2 = ct
            
            elif S[ct] == '<' and not x2:
                x2 = ct
            ct -= 1
        
        if y1 < x1 or y2 < x2:
            print(0)
        
        else:
            print(min(y2-x2, y1-x1))
            