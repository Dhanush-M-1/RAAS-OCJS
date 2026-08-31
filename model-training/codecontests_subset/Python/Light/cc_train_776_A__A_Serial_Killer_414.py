ans = input().split()
n = int(input())
while(n is not 0):
    print(ans[0],ans[1])
    a,b=input().split()
    ans[ans.index(a)]=b
    n-=1
print(ans[0],ans[1])