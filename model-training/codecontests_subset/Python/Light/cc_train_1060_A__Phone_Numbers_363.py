n=int(input())
s=input()
k=n//11
a=0
i=0
for i in range(0,n):
    if s[i]=="8":
        a += 1
print(min(k,a))