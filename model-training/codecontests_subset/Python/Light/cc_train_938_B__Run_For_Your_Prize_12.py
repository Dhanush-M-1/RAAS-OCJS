#This code sucks, you know it and I know it.  
#Move on and call me an idiot later.

n = int(input())
l = list(map(int, input().split()))
l.sort()

l1 = [i-1 for i in l]
l2 = [1000000-i for i in l]

ans = 0
for i in range(n):
    if l2[i] < l1[i]:
        ans = max(ans, l2[i])
    else:
        ans = max(ans, l1[i])
print(ans)