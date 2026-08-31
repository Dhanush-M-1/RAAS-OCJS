t = int(input())
for _ in range(t):
    ans = []
    final = []
    n = int(input())
    for i in range(n):
        s = input()
        lol = list(s)
        ans.append(s)
    a = ans[0][1]
    b = ans[1][0]
    
    x = ans[n-2][n-1]
    y = ans[n-1][n-2]
    
    #print(a,b,x,y)
    if(b != '0'):
        final.append([2,1])
    if(a!='0'):
        final.append([1,2])
    if(y!='1'):
        final.append([n,n-1])
    if(x!='1'):
        final.append([n-1,n])
    if(len(final) <=2):
        
        print(len(final))
        for i in final:
            print(*i,end ='\n')
    else:
        final = []
        if(b != '1'):
            
            final.append([2,1])
        if(a!='1'):
            final.append([1,2])
        if(y!='0'):
            final.append([n,n-1])
        if(x!='0'):
            final.append([n-1,n])
        print(len(final))
        for i in final:
            print(*i,end ='\n')    
            