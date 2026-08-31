t = int(input())
for z in range(t):
        
    n = int(input())
    s = input()

    if(s[0]=='>' or s[n-1]=='<'):
        ans = 0

    else:
        for i in range(n):
            #print(i,s[i])
            if(s[i] == '>'):
                ans1 = i
                break

        
        for i in range(n-1,-1,-1):
            #print(i,s[i])
            if(s[i] == '<'):
                ans2 = n-i-1
                break

        if(ans1 < ans2):
            ans = ans1
        else:
            ans = ans2
            
    print(ans)

