N=int(input())
s=input()
count=0
for i in s:
    if i=='8':
        count=count+1
if count !=0:
    p=N/11
    if p>count:
        print(count)
    else:
        print(int(p))
else:
    print(0)