n,m=map(int,input().split())
s=sorted(list(map(int,input().split())),reverse=True)
for i in s:
    if m%i==0:
        print(m//i)
        break