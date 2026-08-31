n, k = map(int, input().split())
print(min(k//a for a in list(map(int, input().split())) if k % a ==0))