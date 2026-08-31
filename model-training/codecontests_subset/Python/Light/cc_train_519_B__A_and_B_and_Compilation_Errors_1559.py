n = int(input())
e = list(map(int,input().split()))
e1 = list(map(int,input().split()))
e2 = list(map(int,input().split()))

print(sum(e)-sum(e1))
print(sum(e1)-sum(e2))
