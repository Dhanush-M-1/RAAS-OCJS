
t = int(input())
for i in range(t):
    s = input()
    
    count = 0
    
    s = list(s)
    
    n = len(s)
    if len(s) == 1:
        print(0)
        continue
        
    if len(s) == 2:
        if s[0] == s[1]:
            print(1)
        else:
            print(0)
        continue
    
    for i in range(1, len(s)):
        if s[i]== s[i-1] or (i-2 >= 0  and s[i] == s[i-2]):
            s[i] = '*'
            
    for i in range(len(s)):
        if s[i]== '*':
            count += 1
            

            
    print(count)
            