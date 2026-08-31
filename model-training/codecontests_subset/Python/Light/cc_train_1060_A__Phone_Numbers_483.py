n = int(input())
m = input()
s = 0
for i in range(n):
    if(m[i] == "8"):
        s+=1
print(min(n//11, s))
