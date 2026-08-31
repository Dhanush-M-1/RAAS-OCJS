from collections import Counter,defaultdict
I =lambda:int(input())
M =lambda:map(int,input().split())
LI=lambda:list(map(int,input().split()))
for _ in range(I()):
    n=I()
    a=[]
    for i in range(n):
        s=input()
        s=list(s)
        a+=[s]
    ans = []
    if a[0][1] == a[1][0]:
        x = a[0][1]
        if a[-1][-2] == x: ans.append((n,  n- 1))
        if a[-2][-1] == x: ans.append((n - 1, n))
    else:
        if a[-1][-2] == a[-2][-1]:
            x = a[-1][-2]
            if a[0][1] == x: ans.append((1, 2))
            if a[1][0] == x: ans.append((2, 1))
        else:
            x = a[0][1]
            ans.append((2, 1))
            if a[-1][-2] == x: ans.append((n, n-1))
            if a[-2][-1] == x: ans.append((n-1, n))
    print(len(ans))
    for i in range(len(ans)):
        print(*ans[i])

        

            
            
                
        
        
            
    


            



        
            




    


      
      
    

  



