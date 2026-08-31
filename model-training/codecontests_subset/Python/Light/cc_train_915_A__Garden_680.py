n,x=map(int,input().split())
arr=[int(new) for new in input().split()]
arr.sort(reverse=True)
for i in arr:
    if(x%i==0):
        ans=x//i
        break
print(ans)