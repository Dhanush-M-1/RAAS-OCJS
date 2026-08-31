n = int(input())
s = input().split()
a = []
i = 0

for i in s:
    a.append(int(i))
a.sort()

a.reverse()
#print(a)

nulls = 0

for i in range(n):
    nulls += (a[i]+1)%2
if nulls >= n-nulls:
    j = 1
else:
    j = 0

while 1:
    flag = 0 
    
    for i in range(len(a)):
        if not(a[i]%2 == j):
            flag = 1
            j = a[i]%2
            #print(a[i])
            a.pop(i)
            
            break    
    if flag == 0:
        break
sum = 0
if len(a)> 0:
    for i in a:
        sum += i
    print(sum)
else:
    print(0)
    