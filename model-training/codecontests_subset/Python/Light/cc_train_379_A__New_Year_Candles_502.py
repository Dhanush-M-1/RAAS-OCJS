a,b = map(int,input().split())
ans = a
while(a>=b):
    ans += int(a/b)
    c = a % b
    a = int(a/b)+c
print(ans)