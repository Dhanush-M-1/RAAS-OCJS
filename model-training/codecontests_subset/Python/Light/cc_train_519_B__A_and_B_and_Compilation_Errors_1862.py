n=int(input())
l=list(map(int,input().strip().split()))
arr=list(map(int,input().strip().split()))
p=list(map(int,input().strip().split()))

a=sum(l)
b=sum(arr)
c=sum(p)

print(a-b)
print(b-c)