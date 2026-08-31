#reading books(easy version)
#code forces
#In the name of god the all mighty


if __name__=="__main__":
    n,k=map(int,input().split())
    both=list()
    alice=list()
    bob=list()
    for i in range(n):
        t,a,b=map(int,input().split())
        if(a and b):
            both.append(t)
        elif(a):
            alice.append(t)
        elif(b):
            bob.append(t)
    both.sort(reverse=True)
    alice.sort(reverse=True)
    bob.sort(reverse=True)
    al=k
    bb=k
    ans=0
    while(True):
        if(al<=0 or bb<=0):
            break
        if(not len(alice) and al>0):
            if(not len(both)):
                break
        if(not len(bob) and bb>0):
            if(not len(both)):
                break
        if(len(both) and len(alice) and len(bob)):
            if(both[-1]<(alice[-1]+bob[-1])):
                ans+=both[-1]
                both.pop()
            else:
                ans+=alice[-1]+bob[-1]
                alice.pop()
                bob.pop()
            al-=1
            bb-=1
        elif(len(alice) and len(bob)):
            if(len(alice)):
                al-=1
                ans+=alice.pop()
            if(len(bob)):
                bb-=1
                ans+=bob.pop()
        else:
            if(len(both)):
                ans+=both.pop()
                al-=1
                bb-=1
    if(al<=0 and bb<=0):
        print(ans)
    else:
        print('-1')
        
                
            
            
    
    
            
            
