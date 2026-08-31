import sys
# sys.setrecursionlimit(10**6) 
input=sys.stdin.readline
t=int(input())
for t1 in range(t):
    s1 = input().strip()
    n = len(s1)
    c = 0
    s = []
    a = 0
    l = []
    for i in range(n):
        s.append(s1[i])
        l.append(0)
    
    for i in range(n):
        if(i+1<n):
            if(s[i]==s[i+1]):
                l[i]+=1
                l[i+1] +=1
        if(i+2<n):
            if(s[i]==s[i+2]):
                l[i]+=1
                l[i+2] +=1
    b = [0]*n
    # print(l)
    for i in range(n):
        if(l[i]!=0):
            if(i-2>=0 and s[i]==s[i-2] and b[i-2]==0):
                b[i] = 1
                if(i+1<n and s[i] == s[i+1]):
                    l[i+1]-=1
                if(i+2<n and s[i] == s[i+2]):
                    l[i+2] -=1 
            if(b[i]!=1):
                if(i-1>=0 and s[i]==s[i-1] and b[i-1]==0):
                    b[i] = 1
                    if(i+1<n and s[i] == s[i+1]):
                        l[i+1]-=1
                    if(i+2<n and s[i] == s[i+2]):
                        l[i+2] -=1 
            if(b[i]!=1):
                if(i+1<n and s[i] == s[i+1]):
                    if(l[i]<l[i+1]):
                        continue
                    else:
                        b[i] = 1
                        if(i+1<n and s[i] == s[i+1]):
                            l[i+1]-=1
                        if(i+2<n and s[i] == s[i+2]):
                            l[i+2] -=1 
            if(b[i]!=1):
                if(i+2<n and s[i] == s[i+2]):
                    if(l[i]<l[i+2]):
                        continue
                    else:
                        b[i] = 1
                        if(i+1<n and s[i] == s[i+1]):
                            l[i+1]-=1
                        if(i+2<n and s[i] == s[i+2]):
                            l[i+2] -=1
        # print(l) 
        # print(b)                       
    
    print(sum(b))

                

        
    # print("cccc",c)       

