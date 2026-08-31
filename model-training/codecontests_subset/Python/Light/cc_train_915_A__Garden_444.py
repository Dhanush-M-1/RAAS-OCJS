l1 = [int(x) for x in input().split()]
total=l1[1]
l2 = [int(x) for x in input().split()]
l2.sort(reverse=True)
ans=1
for x in l2:
    if total%x==0:
        ans=x
        break
ans = total//ans
print(ans)