y = str(input())

n = int(input())

X = []

for i in range(n):
    x = str(input())
    X.append(x)

cur = -1

for i in range(n):
    if((X[i][0] == y[1] and X[i][1] == y[0]) or (X[i][0] == y[0] and X[i][1] == y[1])):
        print("YES")
        exit()
        
for i in range(n):
    if(X[i][1] == y[0]):
        cur = i
        break

if(cur == -1):
    print("NO")
    exit()

for i in range(n):
    if(X[i][0] == y[1] and i != cur):
        print("YES")
        exit()

print("NO")