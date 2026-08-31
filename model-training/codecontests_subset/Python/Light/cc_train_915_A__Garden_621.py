n,k=map(int,input().split())
l=list(map(int,input().split()))
print(min([k//i for i in l if k%i==0]))