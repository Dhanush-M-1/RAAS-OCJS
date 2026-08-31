n,k=map(int, input().split())
l=list(map(int, input().split()))
# s=input()
a=0
l.sort(reverse=True)
for i in range(n):
    if k%l[i]==0:
        print(k//l[i])
        break