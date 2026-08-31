pas=input()
n=int(input())
a=[]
found=False
for i in range(n):
    temp=input()
    a.append(temp)
    if(temp==pas):
        found=True
for i in a:
    for j in a:
        if(pas in (i+j)):
            
            found=True
            break
        #print(i+j)

if(found):
    print("YES")
else:
    print("NO")
    