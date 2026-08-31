for _ in range(int(input())):
    s1,s2=map(str,input().split())
    l2=list(s2)
    
    if(s1<s2):
        print(s1)
    else:
        l1=list(s1)
        l1.sort()
        
        t=-1
        for i in range(len(l1)):
            if(l1[i]<s1[i]):
                t=i
                break
        #print(t)
        l1=list(s1)
        if(t==-1):
            print("---")
        else:
            f=0
            
            for i in range(t+1,len(s1)):
                
                p=l1[i]
                l1[i]=l1[t]
                l1[t]=p
                #swap(s1[i],s1[t])
                #s="".join(map(str,l2))
                if(l1<l2):
                    f=1
                    s="".join(map(str,l1))
                    break
                else:
                    #swap(s1[t],s1[i])
                    p=l1[i]
                    l1[i]=l1[t]
                    l1[t]=p 
                    
            if(f==1):
                print(s)
            else:
                print("---")
                    