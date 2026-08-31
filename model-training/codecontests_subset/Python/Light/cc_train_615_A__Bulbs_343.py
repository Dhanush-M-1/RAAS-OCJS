a = [int(x) for x in input().split()];
bulbs=[];
for i in range(0,a[1]):
    bulbs.append(0);
for i in range(0,a[0]):
    b = [int(x) for x in input().split()];
    for j in range(1,len(b)):
        bulbs[b[j]-1]=1;
if(min(bulbs)==0):
    print("NO");
else:
    print("YES");
