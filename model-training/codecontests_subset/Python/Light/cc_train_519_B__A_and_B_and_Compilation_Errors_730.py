n=int(input())
l=list(map(int,input().split()))
m=list(map(int,input().split()))
s=list(map(int,input().split()))
print(sum(l)-sum(m))
print(sum(m)-sum(s))
        