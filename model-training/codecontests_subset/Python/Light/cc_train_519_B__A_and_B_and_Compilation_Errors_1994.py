n = int(input())

x = list(map(int,input().split()))
z = list(map(int,input().split()))
c = list(map(int,input().split()))

print(abs(sum(x)-sum(z)))
print(abs(sum(z)-sum(c)))
