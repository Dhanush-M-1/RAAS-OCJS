t=int(input())
for i in range(t):
    n = int(input())
    play,clear = map(int,input().split())
    flag=0
    if(play<clear):
        flag=1
    for j in range(n-1):
        a,b = map(int,input().split())
        if(flag==0):
            if(a<play or b<clear):
                flag=1
            elif(a==play and b>clear):
                flag=1
            elif(a-play<b-clear):
                flag=1
            else:
                play=a
                clear=b
    if(flag==1):
        print("NO")
    else:
        print("YES")
        
        
        
    
            
            
        
    
        