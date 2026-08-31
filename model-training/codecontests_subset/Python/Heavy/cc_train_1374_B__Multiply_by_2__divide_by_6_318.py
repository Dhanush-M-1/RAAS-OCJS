a=int(input())
dict_val={1:0,2:-1,3:2,4:-1,5:-1,6:1,7:-1,8:-1,9:4}
for i in range(a):
    val=int(input())
    #dict_val={"2":-1,"3":2,"4":-1,"5":-1,"6":1,"7":-1,"8":-1,"9":4}
    
    #print("Val",val)
    breakval="hi"
    if val<10:
        print(dict_val[val])
    else:
        quo=val
        count_val=int(0)
        count_val2=int(0)
        while quo!=1:
            rem=quo%6
            #print("Rem",rem)
            if rem==0:
                quo=quo//6
                #print("Quo",quo)
                count_val=count_val+1
                #print("count",count_val)
            else:
               break
        while quo!=1:
            rem=quo%3
            #print("Rem",rem)
            if rem==0:
                quo=quo//3
                #print("Quo",quo)
                count_val2=count_val2+1
                #print("count",count_val)
            else:
               break
        if quo==1:
            print(count_val+2*count_val2)
        else:
            print("-1")
            
        
            
        
        
    

        
        
    


