def f(x,ans):
    if(x%6 == 0):
        return [x//6,ans+1]
    if(x%3 == 0):
        return [2*x//6,ans+2]
    return -1
    
for i in range(int(input())):
    z = int(input())
    p = -234
    ans = 0
    while(1):
        if(z == 1):
            print(0)
            break
        res = f(z,ans)
        if(res == -1):
            print(-1)
            break
        elif(res[0] == 1):
            print(res[1])
            break
        else:
            ans = res[1]
            z = res[0]
            
    
                
            
