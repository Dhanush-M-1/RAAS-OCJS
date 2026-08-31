from collections import Counter
for ad in range(int(input())):
    s=list(input())
    n=len(s)
    ans=0
    a=ord("a")
    '''for i in range(n-1):
        if s[i]==s[i+1]:
            ans+=1
            x=[s[i]]
            if i>0:
                x.append(s[i-1])
            if i<n-3:
                x.append(s[i+3])
            if i<n-2:
                x.append(s[i+2])
            for i in range(5):
                if chr(a+i) not in x:
                    s[i+1]=chr(a+i)
                    break'''

    for i in range(n-2):
        if s[i]==s[i+2]:
            ans += 1
            x = [s[i],s[i+1],s[i+2]]
            if i < n - 3:
                x.append(s[i + 3])
            if i < n - 4:
                x.append(s[i + 4])
            for j in range(6):
                if chr(a + j) not in x:
                    s[i + 2] = chr(a + j)
                    break
        if s[i] == s[i + 1]:
                ans += 1
                x = [s[i],s[i+1]]
                if i > 0:
                    x.append(s[i - 1])
                if i < n - 3:
                    x.append(s[i + 3])
                if i < n - 2:
                    x.append(s[i + 2])
                for j in range(6):
                    if chr(a + j) not in x:
                        s[i + 1] = chr(a + j)
                        break
        '''for j in range(min(i,n-i-3)+1):
                if s[i-j]==s[i+2+j]:
                    continue
                else:
                    break
                    #len is j both sides
                    # i+1 se j unit aaage peche jaa skte h
            c=Counter(s[i+1-j:i+1+j+1])
            temp=ans
            for y in c.values():
                if y<4:
                    continue
                else:
                    ans+=y//2
            if temp==ans:
                ans+=1'''
    if n>1 and s[-1]==s[-2]:
        ans+=1
    print(ans)