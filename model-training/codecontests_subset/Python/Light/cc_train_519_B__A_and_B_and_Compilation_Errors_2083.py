t = int(input())
l = list(map(int,input().split()))
m = list(map(int,input().split()))
n = list(map(int,input().split()))

lst = []

sm1 = sum(l)
sm2 = sum(m)
sm3 = sum(n)

print(sm1-sm2)
print(sm2-sm3)