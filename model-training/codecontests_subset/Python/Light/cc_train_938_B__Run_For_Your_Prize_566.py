n = int(input())
a = list(map(int,input().split()))
c = []
for i in range(len(a)):
    if(a[i]<=pow(10,6)//2):
        c.append(a[i]-1)
    else:
        c.append(pow(10,6)-a[i])
print(max(c))
