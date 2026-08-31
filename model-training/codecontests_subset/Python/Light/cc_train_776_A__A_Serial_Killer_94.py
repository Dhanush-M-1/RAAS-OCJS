vic1=input().split()
n=int(input())#list(map(int,input().split()))
for i in range(n):
    print(' '.join(vic1))
    t=input().split()
    if vic1[0]==t[0]:
        vic1[0]=t[1]
    else:vic1[1]=t[1]
print(' '.join(vic1))
