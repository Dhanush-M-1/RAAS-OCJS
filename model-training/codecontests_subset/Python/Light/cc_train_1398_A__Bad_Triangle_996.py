import bisect

def solve(arr,n,ans):
    for j in range(1,n):
        total = arr[j]+arr[0]
        k = bisect.bisect(arr,total-1)
        if k != len(arr):
            ans.append('1'+' '+str(j+1)+' '+str(k+1))
            return

    ans.append('-1')

def main():
    t = int(input())
    ans = []
    for i in range(t):
        n = int(input())
        arr = list(map(int,input().split()))
        solve(arr,n,ans)

    print('\n'.join(ans))
    

main()
