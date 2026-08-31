t=int(input())
for j in range(t):
    ans = []
    n=int(input())
    li = []
    for i in range(n):
        s=input()
        k=len(s)
        li.append(s)
    if li[0][1] == li[1][0]:
        if li[k-2][n-1] == li[k-1][n-2]:
            if li[0][1] == li[k-2][n-1]:
                r = []
                r.append(1)
                r.append(2)
                ans.append(r)
                r = []
                r.append(2)
                r.append(1)
                ans.append(r)
        else:
            if li[0][1] == li[k-2][n-1]:
                r = []
                r.append(k-1)
                r.append(n)
                ans.append(r)
            else:
                r = []
                r.append(k)
                r.append(n-1)
                ans.append(r)
    else:
        if li[k-2][n-1] == li[k-1][n-2]:
            if li[0][1] == li[k-2][n-1]:
                r = []
                r.append(1)
                r.append(2)
                ans.append(r)
            else:
                r = []
                r.append(2)
                r.append(1)
                ans.append(r)
        else:
            if li[0][1] == li[k-2][n-1]:
                r = []
                r.append(1)
                r.append(2)
                ans.append(r)
                r = []
                r.append(k)
                r.append(n-1)
                ans.append(r)
            else:
                r = []
                r.append(1)
                r.append(2)
                ans.append(r)
                r = []
                r.append(k-1)
                r.append(n)
                ans.append(r)
    print(len(ans))
    for k in range(len(ans)):
        print(ans[k][0],end=" ")
        print(ans[k][1])
                   
                     
                
                
            
    
