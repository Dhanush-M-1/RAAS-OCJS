n,k = map(int,input().split(" "))

lamps = [0]*k
for i in range(1,n+1):
    x = list(map(int,input().split(" ")))
    y = x[1:]
    for j in y :
        lamps[j-1]+=1

for i in lamps:
    if i == 0:
        print("NO")
        break
else:
    print("YES")
