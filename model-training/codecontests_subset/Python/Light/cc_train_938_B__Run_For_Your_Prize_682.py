n=int(input())
l=list(map(int,input().split()))
Min=0
Max=1000000
ans=0
for i in l:
    if(i==500000):
        ans=499999
    elif(i>500000 and i<Max):
        Max=i
    elif (i < 500000 and i>Min):
        Min = i
print(max(ans,Min-1,1000000-Max))