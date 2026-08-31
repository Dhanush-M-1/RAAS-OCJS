n=int(input())
l=list(map(int,input().split()))
x=1000000
s=[]
for i in range(n):
    s.append(min(l[i]-1,x-l[i]))
print(max(s))
