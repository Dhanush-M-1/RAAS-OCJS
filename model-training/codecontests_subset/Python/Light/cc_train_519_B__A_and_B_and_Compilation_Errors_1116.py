n=int(input())
x=[]
y=[]
z=[]
x=input().split()
y=input().split()
z=input().split()
x.sort()
y.sort()
z.sort()
for i in range(n-1):
    if((x[i])!=(y[i])):
        print(int(x[i]))
        break
else:
    print(int(x[n-1]))
for i in range(n-2):
    if((y[i])!=(z[i])):
        print(int(y[i]))
        break
else:
    print(int(y[n-2]))

