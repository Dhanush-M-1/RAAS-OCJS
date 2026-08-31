n = int(input())
s = input()
count = 0
for i in range(n):
    if s[i] == "8":
        count +=1
if count == 0:
    print(0)
else:
    print(min(n//11,count))