n = input()

butt , bulb = n.split(" ")

count = 0

q = []


while count < int(butt):
    s= input()
    s= s.split(" ")
    s.pop(0)
    for x in s:
        q.append(int(x))

    count+=1



q = set(q)

if len(q) == int(bulb) :
    print ("YES")
else:
    print ("NO")


    

        



    





        
            
        
    
