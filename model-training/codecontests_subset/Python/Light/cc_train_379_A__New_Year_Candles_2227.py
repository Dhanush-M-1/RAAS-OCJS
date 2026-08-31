line = input().split()
a = int(line[0])
b = int(line[1])
ans = a 
cur = a

while(int(a/b)):
    ans += int(a/b)
    a = int(a/b) + (a % b)
print(ans)