n=int(input())
if(n>2):
    a=2
    A=list(map(int,input().split()))    
    B=list(map(int,input().split())) 
    for i in range(n-2):
        C=list(map(int,input().split())) 
        if(B[0]-A[0]>B[1]):
            a+=1       
        elif(C[0]-B[0]>B[1]):
            a+=1
            B[0]=B[0]+B[1]
        A,B=B,C    
    print(a)    
else:
    print(n)