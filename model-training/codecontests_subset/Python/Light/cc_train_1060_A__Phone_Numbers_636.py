n=int(input())
m=len(input().replace('8',''))
print(min(n//11, n-m))