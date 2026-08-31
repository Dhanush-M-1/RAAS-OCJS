def solve(s,n,m,arr,ans):
    counts = [0]*(n+1)
    for i in arr:
        counts[1] += 1
        counts[i+1] -= 1

    counts.pop(0)
    for i in range(1,n):
        counts[i] += counts[i-1]

    for i in range(n):
        counts[i] += 1
    letters = [0]*26
    for i in range(n):
        letters[ord(s[i])-ord('a')] += counts[i]

    ans.append(letters[:])

def main():
    t = int(input())
    ans = []
    for i in range(t):
        n,m = map(int,input().split())
        s = input()
        arr = list(map(int,input().split()))
        solve(s,n,m,arr,ans)

    for i in ans:
        for j in i:
            print(j,end = ' ')

        print()


main()
