n,k = map(int, input().split())
alice = list() 
bob = list() 
common = list()  
for _ in range (n):
    t,a,b = map(int, input().split()) 
    if a == 1 and b == 1: 
        common.append (t)  
    elif a == 1: 
        alice.append (t)  
    elif b == 1: 
        bob.append (t) 

if len(common) + len(alice) < k: 
    ans = -1 
elif len(common) + len(bob) < k: 
    ans = -1
else: 
    common.sort()  
    alice.sort() 
    bob.sort() 

    commonP = [0]*len(common)
    aliceP = [0]*len(alice)
    bobP = [0]*len(bob) 

    if len(common) > 0: 
        commonP[0] = common[0] 
        for i in range (1, len(commonP)): 
            commonP[i] = commonP[i-1] + common[i] 

    if len(alice) > 0: 
        aliceP[0] = alice[0] 
        for i in range (1, len(alice)): 
            aliceP[i] = aliceP[i-1] + alice[i] 
    
    if len(bob) > 0: 
        bobP[0] = bob[0] 
        for i in range (1, len(bob)): 
            bobP[i] = bobP[i-1] + bob[i] 

    # print (common, commonP) 
    # print (alice, aliceP) 
    # print (bob, bobP) 

    if len(common) == 0: 
        ans = aliceP[k-1] + bobP[k-1] 
    else: 
        ans = None 
        for i in range (0, len(common)+1):  
            
            if i > k: break
            if i == k: choice = commonP[k-1]      
            else:
                if len(alice)<(k-i) or len(bob)<(k-i): continue
             
                if i ==0: choice = 0 
                else: choice = commonP[i-1] 

                try: 
                    choice += aliceP[k-i-1] 
                except: pass 

                try: 
                    choice += bobP[k-i-1] 
                except: pass 

                # print (i, choice)
            if ans == 0: continue 
                
            if ans is None: 
                ans = choice
            else: 
                ans = min (ans, choice) 

print (ans)  