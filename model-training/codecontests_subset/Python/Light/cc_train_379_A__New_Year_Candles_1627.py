nm=input().split()

nm=[int(x) for x in nm]

n=nm[0]
m=nm[1]

bivajjo=n

result=n

while(True):
  if(bivajjo//m+bivajjo%m>=m):
    result+=bivajjo//m 
    bivajjo=bivajjo//m+bivajjo%m
    
    
  else:
    result+=bivajjo/m
    break
  
  #print(result)
  
print(int(result))