a,b=map(int,input().split())
s='';count=0
ar=[i for i in range(1,b+1)]
for i in range(a):
    n=input()
    s+=n[1:]
for i in ar:
    if str(i) not in s:
        count=1
        break
if count==1:
    print("NO")
else:
    print("YES")