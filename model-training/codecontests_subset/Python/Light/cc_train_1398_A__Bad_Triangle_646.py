t = int(input())
while(t):
    n = int(input())
    l = [int(i) for i in input().split()]
    for i in range(n):
        for j in range(1,n):
            for k in range(2,n):
                if((l[i] + l[j]) > l[k]):
                    pass
                else:
                    print(i+1,j+1,k+1)
                    break

            else:
                print(-1)
                break
            
            break
        break

    t-=1
    
        
