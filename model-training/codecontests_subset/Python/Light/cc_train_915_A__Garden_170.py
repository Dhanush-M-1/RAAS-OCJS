x , y = map(int , input().split())
arr = list(map(int ,input().split()))
ans = min([y//r for r in arr if y % r == 0])
print(ans)