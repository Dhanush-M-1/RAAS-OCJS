for t in range(int(input())):  
    (s,c) = input().split(' ')
    s,c = list(s),list(c)
    
    copy_s = s.copy()
    copy_s.sort()
    
    i = 0
    while i < len(s):
        if copy_s[i] != s[i]:
            break
        i += 1
        
    if i < len(s):
        j = len(s)-1
        while j > i:
            if s[j] == copy_s[i]:
                s[i],s[j] = s[j],s[i]
                break
            j -= 1
    
    same = True
    flag = False
    for i in range(min(len(s),len(c))):
        if s[i] < c[i]:
            flag = True
            same = False
            break
        elif not(flag) and s[i] > c[i]:
            same = False
            break
            
    if same and len(s) < len(c):
        print(''.join(s))
    elif flag:
        print(''.join(s))
    else:
        print('---')