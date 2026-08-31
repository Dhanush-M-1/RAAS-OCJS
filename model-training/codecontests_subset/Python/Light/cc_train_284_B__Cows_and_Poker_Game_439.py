n = int(input())
s = input()

if s.count("I")<2:
    if s.count("I")==1:
        print(1)
        
    else:
        print(s.count("A"))
    
else:
    print(0)