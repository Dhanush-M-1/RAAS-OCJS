a=0
n=int(input())
s=input()
for i in s:
    if i == '8':
        a+=1

print(min(n//11,a))
