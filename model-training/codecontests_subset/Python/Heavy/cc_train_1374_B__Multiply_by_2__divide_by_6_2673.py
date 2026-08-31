def ans(n):
    cnt = 0
    if(n==1):
        return 0
    while(True):
        if(n==1):
            
            break
        else:
            if(n%6==0):
                n//=6
                cnt+=1
            else:
                if(n%3==0 and n%2!=0):
                    n*=2
                    cnt+=1
                elif(n%3!=0):
                    break
    if(cnt==0 or n!=1):
        return -1
    else:
        return cnt
                    
                
                
            
for _ in range(int(input())):
    n = int(input())
    print(ans(n))