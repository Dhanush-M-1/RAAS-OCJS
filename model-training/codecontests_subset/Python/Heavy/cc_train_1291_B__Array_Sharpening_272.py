for _ in range(int(input())):
    N = int(input())
    A = list(map(int,input().split(" ")))
    if N==1:
        print("Yes")
    elif N==2:
        if A[0] == A[1] == 0:
            print("No")
        else:
            print("Yes")
    else:
        D = A.copy()
        flag=0
        c =0;index =0 
        for i in range(N):
            y = A[i] - c
            if y>=0:
                A[i] = c
            else:
                index = i
                break
            c+=1
        #print(index)
        if index!=0:
            d = 0
            for i in range(N-1,i-1,-1):
                y = A[i] - d
                if y>=0:
                    A[i] = d
                else:
                    flag = 1
                    break
                d+=1
            
        #print(index,A)
        
        if A[index] == A[index-1]:
            if D[index] <= A[index] and D[index-1] <= A[index-1]:
                flag=1
        print("Yes") if flag==0 else print("No")
                    
                
    
                