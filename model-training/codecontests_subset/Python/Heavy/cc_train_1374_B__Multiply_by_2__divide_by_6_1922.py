

def main():

    t = int ( input ())
    x =[]
    c =[]
    temp = int(0)
    for i in range(t):
        c.append(0)
    for i in range(t):
        
        x.append(int(input()))
        if(x[temp] == 0):
             print(c[i])
        else:
            while (  x[temp] != 1 and  c[i] != -1 ) :
                if (x[temp]%6 == 0) :
                    x[temp]=x[temp]//6
                    c[i]+=1

                elif ( ( x[temp] * 2 )%6 == 0) :
                    x[temp] = x[temp]*2
                    c[i]+=1
                    x[temp] = x[temp]//6
                    c[i]+=1
                else :
                    c[i] = -1

    
        temp = temp+1
    for i in range(t):
        print(c[i])        
#            break
            



            
    
                  
main()
