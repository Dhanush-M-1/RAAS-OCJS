n = int(input())
s = input()
temp = 0
for i in range(len(s)):
    if(s[i]=='8'):
        temp+=1
    
print(min(temp,n//11))