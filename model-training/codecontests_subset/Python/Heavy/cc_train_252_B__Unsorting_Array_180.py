n = int(input())

data = list(map(int,input().split()))

mins = [0 for i in range(n)]

maxs = [0 for i in range(n)]

mins_back = [0 for i in range(n)]

maxs_back = [0 for i in range(n)]

min_ = data[0]
mins[0] = 0
max_ = data[0]
maxs[0] = 0

if n == 2:
    print( - 1)
    exit(0)

for i in range(n):
    if data[i] < min_:
        min_ = data[i]
        mins[i] = i
    else:
        if i > 0:
            mins[i] = mins[i - 1]
    
    if data[i] > max_:
        max_ = data[i]
        maxs[i] = i
    else:
        if i > 0:
            maxs[i] = maxs[i - 1]
    

    
for i in range(1, n - 1):
    if data[i] != data[mins[i]]:
        if mins[i] == i - 1 and data[mins[i]] < data[i  +1]:
            print(i + 1 , mins[i] + 1)
            exit(0)
            
        if data[i - 1] > data[mins[i]] and data[mins[i]] < data[i  +1]:
            print(i + 1, mins[i]  +1)
            exit(0)
            
    if data[i] != data[maxs[i]]:
        
        if maxs[i] == i - 1 and data[maxs[i]] >  data[i + 1]:
            print(i + 1 , maxs[i] + 1)
            exit(0)
        
        if data[i - 1] <data[maxs[i]] and data[maxs[i]] > data[i  +1]:
            print(i + 1 , maxs[i] + 1)
            exit(0)
            
data = data[::-1]

min_ = data[0]
mins[0] = 0
max_ = data[0]
maxs[0] = 0

for i in range(n):
    if data[i] < min_:
        min_ = data[i]
        mins[i] = i
    else:
        if i > 0:
            mins[i] = mins[i - 1]
    
    if data[i] > max_:
        max_ = data[i]
        maxs[i] = i
    else:
        if i > 0:
            maxs[i] = maxs[i - 1]


for i in range(1, n - 1):
    if data[i] != data[mins[i]]:
        if mins[i] == i - 1 and data[mins[i]] < data[i  +1]:
            print(n - i , n - mins[i])
            exit(0)
            
        if data[i - 1] > data[mins[i]] and data[mins[i]] < data[i  +1]:
            print(n - i, n - mins[i])
            exit(0)
    if data[i] != data[maxs[i]]:
        
        if maxs[i] == i - 1 and data[maxs[i]] >  data[i + 1]:
            print(n - i , n - maxs[i])
            exit(0)
        
        if data[i - 1] <data[maxs[i]] and data[maxs[i]] > data[i  +1]:
            print(n - i, n - maxs[i])
            exit(0)




data[0], data[-1] = data[-1], data[0]
if data[0] == data[-1]:
    print(-1)
    exit(0)

for i in range(1, n - 1):
    if data[i] < data[i -1] and data[i] < data[i + 1]:
        print(1, n)
        exit(0)

    if data[i] > data[i -1] and data[i] > data[i + 1]:
        print(1, n)
        exit(0)

print(-1)




