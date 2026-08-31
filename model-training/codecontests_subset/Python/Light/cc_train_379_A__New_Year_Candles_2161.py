a,b = (int(i) for i in input().split())
time = a

while True:
    time+=a//b
    ost = (a%b)+a//b
    a = ost
    if a<b:
        break
print(time)
        

    
                    
    

            
        


    


 


