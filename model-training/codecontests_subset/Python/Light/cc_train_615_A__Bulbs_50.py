n,m=map(int,input().split())
l2=[]
while(n):
    l=list(map(int,input().split()))
    l1=l[1:]
    l2.append(l1)
    n=n-1
#print(l2)
output = []
def reemovNestings(l2):
    for i in l2:
        if type(i) == list:
            reemovNestings(i)
        else:
            output.append(i)
reemovNestings(l2)
s=set(output)
#print(s)
if(len(s)==m):
    print("YES")
else:
    print("NO")