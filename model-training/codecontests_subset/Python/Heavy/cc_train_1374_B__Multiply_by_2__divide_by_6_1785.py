for _ in range(int(input())):
    n = int(input())
    cnt = 0
    if(n%2==0 and n%6!=0):
        print(-1)
    else:
        while(True):
            if(n == 1):
                print(cnt)
                break
            if(n%2==0 and n%6!=0):
                print(-1)
                break
            if(n>=6):
                if(n%6==0):
                    n = n//6
                    cnt+=1
                else:
                    n = n*2
                    cnt+=1
            elif(n<6):
                n = n*2
                cnt+=1
            
