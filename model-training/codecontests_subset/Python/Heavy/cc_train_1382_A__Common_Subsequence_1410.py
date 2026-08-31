from sys import stdin

def solve(n1, n2, arr1, arr2):
    smol, big = [arr1, arr2] if n1<n2 else [arr2, arr1]
    ans = []
    for i in range(min(n1,n2)):
        if smol[i] in big:
            ans += [smol[i]]
            break

    if len(ans) > 0: print(f"YES \n1 {ans[0]}")
    else: print("NO")


t = int(stdin.readline())

for _ in range(t):
	n1, n2 = list(map(int, stdin.readline().rstrip().split()))
	arr1 = list(map(int, stdin.readline().rstrip().split()))
	arr2 = list(map(int, stdin.readline().rstrip().split()))

	solve(n1, n2, arr1, arr2)