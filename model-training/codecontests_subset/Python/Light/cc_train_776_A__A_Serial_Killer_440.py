y=list(map(str,input().split()))
for _ in range(0,int(input())):
    x=input().split()
    y.extend(x)
print(y[0],y[1],end=" ")
print()
for i in range(2,len(y),2):
    if y[i]==y[i-2]:
        y[i]=y[i-1]
    elif y[i]==y[i-1]:
        y[i]=y[i-2]
for i in range(2,len(y),2):
    print(y[i],y[i+1])
        