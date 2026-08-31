n,m=map(int,input().split())
total=[]
for i in range(n):
    total+=input().split()[-1:0:-1]
    #i.e. total.extend(input().split()[-1:0:-1])
print(["NO","YES"][len(set(total))==m])
