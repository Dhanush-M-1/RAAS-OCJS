for _ in range(int(input())):
    s = input()
    n = len(s)
    l = [0 for i in range(n)]
    if n==1 or n==0:
        print(0)
    else:
        ans = 0
        if s[1]==s[0]:
            ans+=1
            l[1]=1
        for i in range(2,n):
            if l[i-1]==1 and l[i-2]==1:
                continue
            if l[i-1]==1:
                if s[i] == s[i-2]:
                    l[i]=1
                    ans+=1
            elif l[i-2]==1:
                if s[i]==s[i-1]:
                    ans+=1
                    l[i]=1
            else:
                if s[i]==s[i-1] or s[i]==s[i-2]:
                    ans+=1
                    l[i]+=1
        print(ans)