for _ in range(int(input())):
    n=int(input())
    big=[]
    flag=0
    for i in range(n):
        small=[]
        a,b=map(int,input().split())
        small.append(a)
        small.append(b)
        big.append(small)
        if(b>a):
            flag=1
    
    if(flag==0):
        for i in range(len(big)-1):
            if(big[i+1][1]>=big[i][1] and big[i+1][0]>=big[i][0]):
                if(big[i+1][1]-big[i][1] > big[i+1][0] - big[i][0]):
                    flag=1
                    break
                
            else:
                flag=1 
                break
            
    if(flag==1):
        print('NO')
    else:
        print('YES')
    
    
    
            