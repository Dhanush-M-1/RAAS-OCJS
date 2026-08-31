n=int(input())

n1=map(int, list(input().split()))
n2=map(int, list(input().split()))
n3=map(int, list(input().split()))

a=sum(n1)
b=sum(n2)
c=sum(n3)

print(abs(b-a))
print(abs(c-b))