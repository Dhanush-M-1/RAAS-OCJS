a=int(input())

for i in range(0,a):
    b=int(input())
    arr=[]
    for i in range(0,b):
        arr.append(input())
    n=b-1
    if(arr[0][1]==arr[1][0]):
        count=0
        if(arr[n-1][n]==arr[0][1]):
            count=count+1 
        if(arr[n][n-1]==arr[0][1]):
            count=count+1 
        print(count)
        if(arr[n-1][n]==arr[0][1]):
            print(n,n+1)
        if(arr[n][n-1]==arr[0][1]):
            print(n+1,n)
    elif(arr[n][n-1]==arr[n-1][n]):
        count=0
        if(arr[n-1][n]==arr[0][1]):
            count=count+1 
        if(arr[n][n-1]==arr[1][0]):
            count=count+1 
        print(count)
        if(arr[n-1][n]==arr[0][1]):
            print(1,2)
        if(arr[n][n-1]==arr[1][0]):
            print(2,1)
    elif(arr[1][1]=='0'):
        count=0
        if(arr[1][0]=='1'):
            if(arr[2][0]=='1'):
                count=count+ 1
        elif(arr[0][1]=='1'):
            if(arr[0][2]=='1'):
                count=count+1
    
        if(arr[n-1][n]=='0'):
            count=count+1 
        else:
            count=count+1 
        print(count)
        if(arr[1][0]=='1'):
            if(arr[2][0]=='1'):
                print(3,1)
        elif(arr[0][1]=='1'):
            if(arr[0][2]=='1'):
                print(1,3)
    
        if(arr[n-1][n]=='0'):
            print(n,n+1)
        else:
            print(n+1,n)
    elif(arr[1][1]=='1'):
        count=0
        if(arr[1][0]=='0'):
            if(arr[2][0]=='0'):
                count=count+1
        elif(arr[0][1]=='0'):
            if(arr[0][2]=='0'):
                count=count+1 
        
        if(arr[n-1][n]=='1'):
            count=count+1 
        else:
            count=count+1 
        print(count)
        if(arr[1][0]=='0'):
            if(arr[2][0]=='0'):
                print(3,1)
        elif(arr[0][1]=='0'):
            if(arr[0][2]=='0'):
                print(1,3)
        
        if(arr[n-1][n]=='1'):
            print(n,n+1)
        else:
            print(n+1,n)
    
            

        
