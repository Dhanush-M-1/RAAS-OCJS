for x in range(int(input())):
    n = int(input())
    m=list(map(int,input().split()))
    r='YES'
    if(n%2==0):
        for i in range(n//2):
            if(i==n//2-1):
                if(m[i]<n//2-1 or m[n-i-1]<n//2-1):
                    r='NO'
                elif(m[i]==m[n-i-1]==n//2-1):
                    r='NO'
                
            
            if(m[i]>=i and m[n-i-1]>=i):
                i+=1
            else:
                r='NO'
                break
    else:
        for i in range(n//2+1):
            
                
            
            if(m[i]>=i and m[n-i-1]>=i):
                i+=1
            else:
                r='NO'
                break
        
    print(r)
        
        
    