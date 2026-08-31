T = int (input ())
 
for I in range (0, T):
    
    N = int (input ())
    X = sorted (list (map (int, input ().split (' '))))
    
    if X [0] + X [1] <= X [- 1]:
        
        print (1, 2, len (X))
        
    else:
        
        print (- 1)