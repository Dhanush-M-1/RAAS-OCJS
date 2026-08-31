def solution(arr):
    a,b,c = arr[0] , arr[1] ,arr[-1]
    if a + b > c :
        return -1 
    return 1 
for _ in range(int(input())):
    n = int(input())
    arr = [int(x) for x in input().split()]
    ans = solution(arr)
    if ans == -1 :
        print(-1)
    else:
        print(ans,ans+1,len(arr))