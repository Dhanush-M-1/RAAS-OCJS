x=[]
ans=[]
output = ""

x = input().split("+")
for j,val in enumerate(x): x[j]=int(val)

length = len(x)

for i in range(length):
    ans.append(int(0))

def sort():
    global x
    global ans
    count = [0,0,0,0]
    for i in range(length):
        count[x[i]] = count[x[i]] + 1
    for i in range(1,4):
        count[i] = count[i] + count[i-1]
    for i in range(length-1,-1,-1):
        num = x[i]
        ans[count[num] - 1] = num
        count[num] = count[num] - 1

sort()

for i in range(length):
    if i<length-1:
        output = output + str(ans[i]) + '+'
    else:
        output = output + str(ans[i])

print(output)
