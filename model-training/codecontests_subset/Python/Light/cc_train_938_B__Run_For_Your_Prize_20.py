n=int(input())
a=list(map(int,input().split()))
print(max(min(i-1,10**6-i) for i in a))