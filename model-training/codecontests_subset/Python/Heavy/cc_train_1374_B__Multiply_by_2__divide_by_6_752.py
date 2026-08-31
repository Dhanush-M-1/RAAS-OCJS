


  
def solve():
    n=int(input())
    c=0
    b=0
    if n==1:
        print(0)
    elif  n<3:
        print(-1)
    else:
        while n%3 ==0:
            n=n//3
            c+=1
        while n%2==0:
            n=n//2
            b+=1
        if c==0 or n !=1 or c<b:
            print(-1)
        else:

            print((c-b)*2+b)




   

  




        

            
   
        


    

T = 1
T = int(input())
for _ in range(1,T+1):
    # print("Case #", _ , file = sys.stderr)
    solve()