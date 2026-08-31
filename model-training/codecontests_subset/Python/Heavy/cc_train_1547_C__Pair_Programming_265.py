for _ in range(int(input())):
    space = input()
    k, n, m = map(int, input().split())
    
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    output = []
    
    sol = [0] * k
    
    i = 0
    j = 0
    
    check = True
    
    while(check and i < len(a) and j < len(b)):
        if (a[i] == 0):
            sol.append(0)
            output.append('0')
            i += 1
        elif (b[j] == 0):
            sol.append(0)
            output.append('0')
            j += 1
        elif (a[i] <= len(sol)):
            output.append(str(a[i]))
            i += 1
        elif (b[j] <= len(sol)):
            output.append(str(b[j]))
            j += 1
        else:
            check = False
            break
        
    while(check and i < len(a)):
        if (a[i] == 0):
            sol.append(0)
            output.append('0')
            i += 1
        elif (a[i] <= len(sol)):
            output.append(str(a[i]))
            i += 1
        else:
            check = False
            break
        
    while(check and j < len(b)):
        if (b[j] == 0):
            sol.append(0)
            output.append('0')
            j += 1
        elif (b[j] <= len(sol)):
            output.append(str(b[j]))
            j += 1
        else:
            check = False
            break
        

    if check:
        print(' '.join(output))
    else:
        print(-1)
            
    
    