t = int(input())
while t>0:
    t-=1
    n = int(input())
    ans = True
    inp = []
    for i in range(0,n):
        x,y = map(int,input().strip().split(" "))
        inp.append((x,y))
    
    if inp[0][0]<inp[0][1]:
        ans = False
    
    for i in range(1,n):
        if inp[i][0]==inp[i-1][0]:
            if inp[i][1]!=inp[i-1][1]:
                ans = False
        if inp[i][0]<inp[i][1]:
            ans = False
        if inp[i][0]<inp[i-1][0]:
            ans = False
        if inp[i][1]<inp[i-1][1]:
            ans = False
        if inp[i][0]-inp[i-1][0]<inp[i][1]-inp[i-1][1]:
            ans = False
            
    if ans:
        print("YES")
    else:
        print("NO")