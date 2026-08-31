n = int(input())
e1 = 0

s = sum(list(map(int,input().split())))
e1 = s - sum(list(map(int,input().split())))
e2 = s - e1 - sum(list(map(int,input().split())))
print(e1)
print(e2)