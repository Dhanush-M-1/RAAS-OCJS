
n,k = [int(x) for x in input().split(' ')]
a = [int(x) for x in input().split(' ')]
for i in sorted(a,reverse=True):
    if k%i==0:
        print(k//i)
        break
   