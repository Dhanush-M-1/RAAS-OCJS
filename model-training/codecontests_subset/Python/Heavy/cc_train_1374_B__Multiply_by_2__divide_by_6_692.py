n=int(input())
for i in range(n):
       x=int(input())
       x1=x
       flag=0
       count=0
       while(x>1):
              if(x%3==0):
                     if(x%6==0):
                            count+=1
                            x=x//6
                     else:
                            count+=2
                            x=x//3
              else:
                     flag=1
                     break
       if(flag==0):
              print(count)
       else:
              print(-1)
                     
       
              