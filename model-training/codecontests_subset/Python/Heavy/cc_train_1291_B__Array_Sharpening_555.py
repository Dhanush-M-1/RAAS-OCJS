while True:
    try:
        n = int(input())
        for i in range(n):
            Y = True
            
            x = int(input())
            y = input().split()
            for j in range(len(y)):
                y[j] = int(y[j])

            if x%2==0:
                if y[x//2]==y[x//2-1]==x/2-1:
                    Y=False
                else:
                    for k in range(x//2):
                        if y[k]<k:
                            Y=False
                            break
                        if y[x-k-1]<k:
                            Y=False
                            break
                #0 1 2 2 1 0 (L=6)
                #0 1 2 3 4 5
            else:
                for k in range((x+1)//2):
                    if y[k]<k:
                        Y=False
                        break
                    if y[x-k-1]<k:
                        Y=False
                        break
            if Y:
                print('Yes')
            else:
                print("No")
                
            

    except EOFError:
        break
