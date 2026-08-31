n = int(input())

data = [0]*n

for i in range(n):
    data[i] = list(map(int, input().split()))

count = 0 
taken_space = 0
for j in range(n):
    if j == 0:
        count+=1
    elif j == n-1:
        count+=1
    elif data[j][0] - data[j-1][0] - taken_space > data[j][1]:
        count+=1
        taken_space = 0
    elif data[j+1][0] - data[j][0] > data[j][1]:
        count+=1
        taken_space = data[j][1]
    else:
        taken_space = 0
        
    
print(count)