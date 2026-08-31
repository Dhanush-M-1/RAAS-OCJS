a = int(input())
n1 = map(int,input().split())
n2 = map(int,input().split())
n3 = map(int,input().split())
r1 = sum(n1)
r2 = sum(n2)
r3 = sum(n3)
x1 = r1 - r2
x2 = r2 - r3
print(x1,x2)