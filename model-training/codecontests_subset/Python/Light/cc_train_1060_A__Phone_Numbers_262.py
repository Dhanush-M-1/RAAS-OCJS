n = int(input())
s = input()

ans = 0;
for i in s:
    if i=='8':
        ans+=1
ans = min(ans,  n//11);
print(ans)

