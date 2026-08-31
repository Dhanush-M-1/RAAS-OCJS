n = int(input())
s = (input())
c = 0
for i in s:
    if i=="8":
        c=c+1

print(min(c,len(s)//11))