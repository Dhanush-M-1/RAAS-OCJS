n=int(input())
s=str(input())
ss=0
for i in s:
    if i=='8':
        ss+=1
print(min(ss,n//11))
