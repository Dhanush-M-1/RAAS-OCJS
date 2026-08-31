s=int(input())

n=input().split()
c=0
for a in range(len(n)):
    #print(n[a],n,1000000-int(n[a]),int(n[a])-1)
    if 1000000-int(n[a])<=int(n[a])-1:
        number=a
        c=1
        if a-1>=0:
          if  1000000-int(n[a])<int(n[a-1])-1:
            c=2
            number=a-1
        break    
    
    
    
if c==0:
    ans=(int(n[-1])-1)
    
elif c==1:
    ans=(1000000-int(n[number]))    

elif c==2:
    ans=int(n[number])-1    
print(ans)    

