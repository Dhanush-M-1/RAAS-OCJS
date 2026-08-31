n,k = map(int,input().split())
a = list(map(int,input().split()))
l = [k//i for i in a if k%i==0]
print(min(l))
