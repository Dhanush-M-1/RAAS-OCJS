n = int(input())
s = input()
b = 0

for i in range(len(s)):
    if(s[i] == "8"):
        b += 1
if(b >= (n//11)):
    print (n//11)
else:
    print (b)
