s = input().strip().split(' ');

n = int(input())
print(s[0], s[1])
for _ in range(n):
    
    f = input().strip().split(' ')
    
    if f[0] == s[0]:
        s[0] = f[1]
    elif f[0] == s[1]:
        s[1] = f[1]
    elif f[1] == s[0]:
        s[0] = f[0]
    else:
        s[1] = f[0]
        
    print(s[0], s[1])    