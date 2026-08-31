a, b = map(int,input().split())
cnt = a
while a>=b:
    a = a-b+1
    cnt+=1
print(cnt)
