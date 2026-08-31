n=int(input())
a=[*map(int,input().split())]
b=[*map(int,input().split())]
c=[*map(int,input().split())]

print(sum(a)-sum(b))
print(sum(b)-sum(c))