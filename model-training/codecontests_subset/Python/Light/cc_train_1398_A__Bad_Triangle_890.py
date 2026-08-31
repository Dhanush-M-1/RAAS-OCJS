for _ in range(int(input())):
    n=int(input())
    l=[int(j) for j in input().split()]
    c=l[0]+l[1]
    f=0
    for i in range(2,n):
        if c<=l[i]:
            print(1,2,i+1)
            f=1
            break
    if f==0:
        print(-1)
    
    
        
                   
    
