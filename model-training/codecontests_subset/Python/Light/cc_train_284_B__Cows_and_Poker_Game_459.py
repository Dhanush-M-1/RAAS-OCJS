import sys
f = sys.stdin
 
n = int(f.readline())
s = f.readline()
 
if "I" in s:
    if s.count("I")==1:
        print(1)
        
    else:
        print(0)
    
else:
    print(s.count("A"))