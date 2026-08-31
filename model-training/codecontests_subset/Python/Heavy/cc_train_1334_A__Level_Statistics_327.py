for _ in range(int(input())):
    
    n = int(input())
    lst = []
    for __ in range(n):
        lst.append(list(map(int,input().split())))
        
    if n==1 and lst[0][0]>=lst[0][1]:
        print('YES')
    elif n==1 and lst[0][0]<lst[0][1]:
        print('NO')
    else: 
        for i in range(n-1):
            
            if lst[i][0] > lst[i+1][0]:
                print('NO')
                break
                
            elif lst[i][0]==lst[i+1][0] and lst[i][1] < lst[i+1][1]:
                print('NO')
                break
                
            elif lst[i][1] > lst[i+1][1]:
                print('NO')
                break
                
            elif lst[i][0]<lst[i][1]:
                print('NO')
                break
                
            elif i==n-2 and lst[i+1][0]<lst[i+1][1]:
                print('NO')
                break
            
            elif abs(lst[i][0]-lst[i+1][0])<abs(lst[i][1]-lst[i+1][1]):
                print('NO')
                break
            
            elif i==n-2:
                print('YES')
        