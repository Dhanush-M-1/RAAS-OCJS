a,b=map(int,input().split())
if(a==b):
        print("0")
else:
        def div(n):
                #sprint(n)
                a1,a2,a3=0,0,0
                while(n%5==0):
                        n=n//5
                        #print(n)
                        a1=a1+1
                
                while(n%3==0):
                        n=n//3
                        a2=a2+1
                while(n%2==0):
                        n=n//2
                        a3=a3+1
                #print(n)
                return n,a1,a2,a3
                
                
                
        a,a1,b2,c=div(a)
        #print("lo")
        b,d,e,f=div(b)
        co=abs(a1-d)+abs(b2-e)+abs(c-f)
        if(a!=b):
                print("-1")
        else:
                print(co)
        
                        
                




                
                
