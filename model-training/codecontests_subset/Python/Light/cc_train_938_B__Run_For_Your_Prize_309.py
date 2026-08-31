n=int(input())
arr=list(map(int,input().split()))
myPosition=1
FriendPosition=10**6
time=0
maxT=0
for i in range(n):
    time=min(abs(myPosition-arr[i]),abs(FriendPosition-arr[i]))
    maxT=max(maxT,time)
print(maxT)

