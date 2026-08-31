n=int(input())
num=input()
e=0
for x in num:
    if x == '8':
        e+=1
print(min(e,n//11))