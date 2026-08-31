


n = int(input())

t = list(map(int,input().split()))
w= list(map(int,input().split()))

v= list(map(int,input().split()))


u=t[0]


for j in range(1,n):
    u^=t[j]
y=w[0]
for k in range(1,n-1):
    y^=w[k]


x=v[0]

for s in range(1,n-2):
    x^=v[s]

print(u^y)
print(y^x)
