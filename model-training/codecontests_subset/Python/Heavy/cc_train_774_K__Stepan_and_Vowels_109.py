n = int(input())
s = input()
ans = ''
now = 0
last = '#'
nowe = ""
nowo = ""

a = ["a", "e", "i", "o", "u", "y"]
b = ["e", "o"]
for i in range(n):
    
    
    if s[i] == "e":
        last = "e"
        if len(nowo) > 2:
            ans += "o"
        else:
            ans += nowo
        nowo = ''
        nowe += 'e'
        
        
    if s[i] == "o":
        last = "o"
        if len(nowe) > 2:
            ans += "e"
        else:
            ans += nowe
        nowe = ''
        nowo += 'o'
        
        
    if s[i] not in a:
        if len(nowo) > 2:
            ans += "o"
        else:
            ans += nowo
        nowo = ''
        
        if len(nowe) > 2:
            ans += "e"
        else:
            ans += nowe
        nowe = ''
            
        ans += s[i]
        last = "#"
        continue
    
    
    if s[i] not in b:
        
        
        if len(nowo) > 2:
            ans += "o"
        else:
            ans += nowo
        nowo = ''
        
        if len(nowe) > 2:
            ans += "e"
        else:
            ans += nowe
        nowe = '' 
            
            
        if last != s[i]:
            last = s[i]
            ans += s[i]
        
        continue
    
#print(ans, "###", nowo)
if len(nowo) > 2:
    ans += "o"
else:
    ans += nowo
    nowo = ''

if len(nowe) > 2:
    ans += "e"
else:
    ans += nowe
    nowe = ''
    
print(ans)