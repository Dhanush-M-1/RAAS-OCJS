n = int(input())
l = list(map(int,input().split()))
i = list(map(int,input().split()))
j = list(map(int,input().split()))

print(sum(l)-sum(i))
print(sum(i)-sum(j))