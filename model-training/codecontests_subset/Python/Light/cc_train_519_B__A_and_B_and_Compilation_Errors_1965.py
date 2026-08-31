n = int(input())
a = sorted(list(map(int,input().split())))
b = sorted(list(map(int,input().split())))
c = sorted(list(map(int,input().split())))
for i,j in zip(a,b):
    if i!=j:
        print(i)
        break
else:
    print(a[-1])
for i,j in zip(b,c):
    if i!=j:
        print(i)
        break
else:
    print(b[-1])