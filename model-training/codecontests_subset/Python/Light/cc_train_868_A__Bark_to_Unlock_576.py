s = input()
n = int(input())
ans = False
first = ""
second = ""
for _ in range(n):
    s1 = input()
    first += s1[0]
    second += s1[1]
    if s1 == s:
        ans = True

if ans == True:
    print("Yes")
else:
    if first.count(s[1]) and second.count(s[0]):
        print("Yes")
    else:
        print("No")
    
        
    
    
        
