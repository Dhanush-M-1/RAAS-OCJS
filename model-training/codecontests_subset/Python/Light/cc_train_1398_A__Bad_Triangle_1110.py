def nextInt():
    return int(input())
def intArr():
    arr = input().split(" ")
    return [int(x) for x in arr]

t = nextInt()
ans = []
for tt in range(t):
    length = nextInt()
    a = []
    s = intArr()
    cur = s.pop()
    if cur-s[0] <= 1:
        ans.append(-1)
    elif cur - (s[0]+s[1]) < 0:
        ans.append(-1)
    else:
        ans.append("1 2 {}".format(len(s)+1))
for x in ans:
    print(x)
