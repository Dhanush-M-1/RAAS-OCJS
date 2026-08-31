# 2nd logic is length of set of l will be equal to m, no need of two for loops  
n,m=map(int,input().split())
l=[]
res=""
for x in range(n):
    no_of_bulb,*bno=map(int,input().split())
    l.extend(bno)
if (len(set(l))==m):
    print("YES")
else:
    print("NO")