n=int(input())
M=[list(map(int,input().split())) for i in range(n) ]
k=1
for i in range(1,n-1) :
    if M[i][0]-M[i][1]>M[i-1][0] :
        k=k+1
    else :
        if M[i][0]+M[i][1]<M[i+1][0] :
            M[i][0]=M[i][0]+M[i][1]
            k=k+1
if n==2 :
    k=2
if n>=3 :
    k=k+1
print(k)
            
    
    
