n = int(input())
a = list(map(int,input().split()))
a.sort(reverse = True)
odd = []
even = []
for i in a:
    if i%2 == 0:
        even.append(i)
    else:
        odd.append(i)
l1 = len(odd)
l2 = len(even)
k = -1
if l1 == l2:
    print(0)
elif l1 == l2+1 or l1 + 1 == l2:
    print(0)
    
elif l1 > l2:
    if l2 == 0:
        odd.remove(odd[0])
        print(sum(odd))
    else:
        k = 1
else:
    if l1 == 0:
        even.remove(even[0])
        print(sum(even))
    else:
        k = 0

if k == 0 or k == 1:
    while len(odd) != 0 and len(even)!= 0:
        if k == 0:
            even.remove(even[0])
            k = 1
        else:
            odd.remove(odd[0])
            k = 0
    if len(even) == 0:
        print(sum(odd[1:]))
    else:
        print(sum(even[1:]))
    
        
    
    
    

    
    

        
        

       
        
    

            
        
            
            
            
        
            
        
    
    
    
    