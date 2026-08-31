t = int(input())
for x in range(1, t+1):
    n = int(input())
    check = True
    p = []
    c = []
    
    for i in range(0, n):
        s = input().split(" ")
        p.append(int(s[0]))
        c.append(int(s[1]))
    
    for i in range(0, n):
        if(i == 0):
            if(p[0] < c[0]):
                check = False
                break
        # elif(p[i] < p[i-1] or c[i] < c[i-1] or c[i] > p[i] or (p[i] == p[i-1] and c[i] > c[i-1] or c[i] < c[i-1])):
        #     check = False
        #     break
        else:
            newP = p[i] - p[i-1]
            newC = c[i] - c[i-1]
            
            if(newP < 0 or newC < 0 or newC > newP):
                check = False
                break
    
    if(check):
        print("YES")
    else:
        print("NO")