n = int(input())
myPos = 1
friendPos = 1000000
a = list(map(int,input().split()))
ans = max(min(i-1,friendPos-i) for i in a)
print(ans)

