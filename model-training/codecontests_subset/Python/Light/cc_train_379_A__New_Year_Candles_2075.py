n, m=map(int, input().split(' '))
days=[]
for i in range(1, 3*n):
    days.append(i)
s=0
i=0
while(s<n):
    if (days[i]%m!=0):
        s+=1
    i+=1
print(i)
