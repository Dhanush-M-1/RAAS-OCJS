def common_data(list1, list2): 
    result = False
    for x in list1: 
        for y in list2: 
            if x == y: 
                result = x
                print("YES")
                print(1,x)
                flag=1
                break
            else:
                flag=0
        if flag==1:
            break
    if flag==0:
        print("NO")
    
for _ in range( int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    common_data(a, b)
    
    
            

            
    
