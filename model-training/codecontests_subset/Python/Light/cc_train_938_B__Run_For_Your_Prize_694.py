n = int(input(""))
x = [int(i) for i in input("").split(" ")]
ans = 0
for a in x:
    ans = max(ans,min(a-1,1000000-a))
print(ans)
