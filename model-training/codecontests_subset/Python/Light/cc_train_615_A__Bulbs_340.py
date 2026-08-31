firstLine=input().split()
n=int(firstLine[0])
m=int(firstLine[1])
x=1
Bulbs=[]
while x<=n :
    key=input().split()
    for l in key[1:]:
        l=int(l)
        if l not in Bulbs:
            Bulbs.append(l)
    x+=1
for M in range(1,m+1):
    if M not in Bulbs:
        print("No")
        break
else:
    print("Yes")
            
    
    
        
    
    
    
