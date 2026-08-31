
q = int(input())

for i in range(q):
    firstlastnum = list(map(int, input().split()))
    first = firstlastnum[0]
    last = firstlastnum[1]
    num = firstlastnum[2]
    div2 = last // num
    if num < first:
        print(num)
    else:
        print(div2*num + num)
