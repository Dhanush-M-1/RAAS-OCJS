a,b = map(int,input().split())
s = list(map(int,input().split()))
d = []
for i in s:
    if b % i == 0:
        d.append(i)
print(b // max(d))