n = int(input())
for i in range(n):
    t = int(input())
    play = []
    clears = []
    PlayOrder = []
    for j in range(t):
        x,y = [int(i) for i in input().split()]
        play.append(x)
        clears.append(y)

    r = 0
    res = 0
    while r<t-1:
        #print(r,play[r],play[r+1],clears[r],clears[r+1])
        if clears[r]>clears[r+1] or play[r]>play[r+1] or play[r]<clears[r] or play[r+1]<clears[r+1]:
            print("NO")
            res=1
            break
        if play[r]==play[r+1] and clears[r]<clears[r+1]:
            print("NO")
            res=1
            break
        if play[r+1]-play[r]<clears[r+1]-clears[r]:
            print("NO")
            res=1
            break
        r+=1
    if res==0:
        if play[0]<clears[0]:
            print("NO")
            res=1
    if res==0:
        print("YES")
