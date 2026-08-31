# 7=>3=>1, 2=>1
# 8/9
# 4=>2=>1

def cal_dis(num,val):
    count = 0
    while num > 0:
        if val[num] == 0: val[num] = []
        val[num].append(count)
        num = num//2
        count += 1
    return count,val

n,k = (int(x) for x in input().split())
seq = [int(x) for x in input().split()]
ans = 10e8
val = 200009 * [0]
for ele in seq:
    count,val = cal_dis(ele,val)

for lis in val:
    if lis != 0:
        if lis.__len__() >= k:
            lis.sort()
            sum = 0
            for ele in lis[:k]:
                sum += ele
            ans = min(ans,sum)
print(ans)
