t = int(input())
for x in range(1, t+1):
    n = int(input())
    check = True
    lastP = 0
    lastC = 0
    
    for i in range(0, n):
        s = input().split(" ")
        p = int(s[0])
        c = int(s[1])
        
        if(i == 0):
            if(p < c):
                check = False
        else:
            newP = p - lastP
            newC = c - lastC
            if(newP < 0 or newC < 0 or newC > newP):
                check = False
        lastP = p
        lastC = c
        
    if(check):
        print("YES")
    else:
        print("NO")