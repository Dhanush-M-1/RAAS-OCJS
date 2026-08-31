n = input()
c=0
v=0
for i in range(int(input())):
    s = input()
    if(n[0]==s[1]): c+=1
    if(n[1]==s[0]): v+=1
    if(n==s):   
        c+=1
        v+=1
print("YES" if(c and v) else "NO")