t = int(input())

count = 0
ans = []

while count < t:
    sto = input()
    a,b,c = sto.split()
    if int(b) == 0 :
        ans.append(0)
    else:
        if int(c) != 0:
            times = int(c)//2
            if int(b) < times :
                tot = int(b) + int(b)*2
                ans.append(tot)
            else:
                tot = times + times*2
                b = int(b) - times
                if (b < 2) or (int(a)==0) :
                    ans.append(tot)
                else:
                    times2 = int(b)//2
                    if times2 < int(a):
                        tot += times2 + times2*2
                        ans.append(tot)
                    else:
                        tot += int(a) + int(a)*2
                        ans.append(tot)
        else:
            if int(a) != 0 :
                tot = 0
                times2 = int(b)//2
                if times2 < int(a):
                        tot += times2 + times2*2
                        ans.append(tot)
                else:
                    tot += int(a) + int(a)*2
                    ans.append(tot)
            else:
                ans.append(0)
                
            
    count += 1

for y in ans:
    print (y)
                
        

    
 





        




    




    

    
    

        
        
        
    
    

    
        



        
        
        
           
        
        
    
    




    
            
        





            
        
            

        
            



        
        
    
        



            


    
    







    



        
        
        
        


            



        
            

    


    

    



        


        



    
        
        

    







    
    
 

    

        
    
            
    




    


        



    





        
            
        
    
