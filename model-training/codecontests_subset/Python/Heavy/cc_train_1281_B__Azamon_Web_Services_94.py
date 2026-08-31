def check(s1,s2):
    s = list(s1)
    s.sort()
    rtn = ''
    if s1<s2:
        return s1
     
    if ''.join(s) > s2:
        
        return '---'

    for i in range (len(s)):
        if s1[i] != s[i]:
            rtn += s1[:i]
            rtn += s[i]
            
            for j in range (len(s)-1,i,-1):
               
                if s1[j]==s[i]:
                    rtn += s1[i+1:j]
                    rtn +=s1[i]
                    rtn += s1[j+1:]
                    
                    return rtn if rtn<s2 else '---'
    return '---'

for rep in range(int(input())):
    print (check(*input().split()))