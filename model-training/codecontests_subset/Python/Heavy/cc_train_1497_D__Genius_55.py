import sys
input = sys.stdin.readline

t=int(input())
for tests in range(t):
    n=int(input())
    Tag=list(map(int,input().split()))
    S=list(map(int,input().split()))

    DP=[0]*n
    
    ANS=0

    for i in range(1,n):

        MAX=0
                
        for j in range(i-1,-1,-1):
            temp=DP[j]

            if Tag[j]!=Tag[i]:
                DP[i]=max(DP[i],DP[j]+abs(S[i]-S[j]))
                DP[j]=max(DP[j],MAX+abs(S[j]-S[i]))


                MAX=max(MAX,temp+abs(S[i]-S[j]))


        #print(DP)
            
        

    print(max(DP))
            
            
            
            
            
            

    
    

