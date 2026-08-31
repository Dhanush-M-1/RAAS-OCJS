import math
t=int(input())
for i in range(t):
    s=input()
    s=list(s)
    l=len(s)
    if l==1:
        print(0)
    elif l==2:
        if s[0]==s[1]:
            print(1)
        else:
            print(0)
    else:
        j=0
        c=0
        while(j<l):
            if j==l-1:
                break
            elif j==l-2:
                if s[j]==s[j+1]:
                    c+=1
                break
            else:
                if s[j]==s[j+1] and s[j+1]==s[j+2]:
                    c+=2
                    j+=3
                elif s[j]==s[j+2]:
                    c+=1
                    s[j+2]=str(j)
                    j+=1
                elif s[j]==s[j+1]:
                    c+=1
                    j+=2
                else:
                    j+=1
            
        print(c)
                
                
            