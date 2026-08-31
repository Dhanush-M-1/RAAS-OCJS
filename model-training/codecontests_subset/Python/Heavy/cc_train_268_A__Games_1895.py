teams = int(input())
count = 0

host  = []
guest = []


while count < teams :
    color = input()
    color = color.split(" ")
    host.append(color[0])
    guest.append(color[1])
    count += 1


times = 0

for x in guest :
    for y in host :
        if x==y:
            times += 1
        else:
            pass

print (times)
        
        
    

        
            



        
        
    
        



            


    
    







    



        
        
        
        


            



        
            

    


    

    



        


        



    
        
        

    







    
    
 

    

        
    
            
    




    


        



    





        
            
        
    
