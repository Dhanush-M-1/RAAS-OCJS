n, k = map(int, input().split())
a = list(map(int, input().split()))

di = {}
cdi = {}

for el in a:
    cdi[el] = 1 if el not in cdi else cdi[el]+1


for el in a:
    ec = el
    di[ec] = [0] if ec not in di else di[ec] + [0]
    lis = [el]
    count = 0
    ec2 = ec
    while ec2 != 0:
        ec2 = ec // (2**(count+1))
        count += 1
        di[ec2] = [count] if ec2 not in di else di[ec2] + [count]
    #print(di)


ans = 9999999999999999999999999999999
for all in di:
    nextlis = di[all]
    if len(nextlis) < k:
        continue
    #print(all, nextlis)
    nextlis = sorted(nextlis)[:k]
    ans = min(sum(nextlis), ans)
print(ans)