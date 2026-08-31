for tc in range(int(input())):
    s,c=list(map(str,input().split()))
    s=list(s)
    
    if ''.join(s)<c:
        print(''.join(s))
    else:
        for i in range(len(s)):
            temp=s[i]
            tem=0
            for j in range(i+1,len(s)):
                
                if temp>=s[j]:
                    temp=s[j]
                    tem=j
            if temp!=s[i]:
                s[tem],s[i]=s[i],s[tem]
                break
        s=''.join(s)
        if s<c:
            print(''.join(s))
        else:
            print("---")
                
            
                    