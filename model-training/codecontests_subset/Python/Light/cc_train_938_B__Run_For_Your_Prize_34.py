n=int(input())
list1=[int(x) for x in input().split()]
prev=[]
aft=[]
for i in list1:
    if i<=500000:
        prev.append(i)
    else:
        aft.append(1000000-i)
if(len(aft)==0):
    x = max(prev) - 1
    #y = max(aft)
    print(x)
elif(len(prev)==0):
    #x = max(prev) - 1
    y = max(aft)
    print(y)
else:
    x = max(prev) - 1
    y = max(aft)
    print(max(x,y))
