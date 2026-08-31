t = int(input())
for i in range(0,t):
    n = int(input())
    prevclears = 0
    prevplays = 0
    possible = True
    for j in range(0,n):
        plays,clears = input().split()
        plays = int(plays)
        clears = int(clears)
        if (clears - prevclears > plays - prevplays) or (clears - prevclears<0) or (plays-prevplays<0):
            possible = False
        prevclears = clears
        prevplays = plays
    if possible:
        print('YES')
    else:
        print('NO')
        
    