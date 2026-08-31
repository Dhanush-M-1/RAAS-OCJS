n = int(input())

line = input().split(' ')
a = []
for i in range(n):
    a.append(int(line[i]))
ans = -1
for i in range(n):
    ans =max(ans,min(a[i]-1,1000000-a[i]))

print(ans)
