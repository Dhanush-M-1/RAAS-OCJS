t = int(input())
for i in range(0, t):
        n = int(input())
        count = 0
        flag = 0
        while(n != 0):
                if n == 1:
                        break
                if n%3 == 0 and n%6 != 0:
                        n = n*2
                        count += 1
                if n%6 != 0:
                        print(-1)
                        flag = 1
                        break
                elif n%6 == 0:
                        n = n//6
                        count += 1
        if flag == 0 : print(count)
        
        
                
