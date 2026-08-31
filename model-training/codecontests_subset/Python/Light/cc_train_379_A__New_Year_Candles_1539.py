n=input()
n=n.split()
a=int(n[0])
b=int(n[1])
c=[]
count=a
for i in range(1,a+1):
    if(i%b==0):
        count+=1
        if(count%b==0):
            count+=1
print(count)
        
        
    