import math
def dtb(n): 
    return bin(n).replace("0b","")
def btd(n): 
    return int(n,2) 
t=int(input())
for k in range(t):
    n=int(input())
    a=[]
    flag=True
    count1,count2=0,0
    if n==1:
        print(0)
        continue
     
    while(n!=1):
        if n%2==0:
            count1+=1
            n=n//2
        elif n%3==0:
            count2+=1
            n=n//3
        else:
            flag=False
            break
        
        
    if flag==False:
        print("-1")
    else:
        if count2<count1:
            print(-1)
        elif count1==count2:
            print(count1)
        elif count2>count1:
            ans=count2-count1
            ans=ans+count2
            print(ans)
            