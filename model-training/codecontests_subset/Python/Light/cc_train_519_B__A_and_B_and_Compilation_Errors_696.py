x = input()
y = list(map(int, input().split()))
c = list(map(int, input().split()))
z = list(map(int, input().split()))




print(sum(y) - sum(c))
print(sum(c) - sum(z))