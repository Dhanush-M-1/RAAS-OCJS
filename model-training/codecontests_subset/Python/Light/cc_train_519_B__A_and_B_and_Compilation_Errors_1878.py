input()
fset = list(map(int, input().split()))
sset = list(map(int, input().split()))
tset = list(map(int, input().split()))

print(sum(fset) - sum(sset))
print(sum(sset) - sum(tset))