import math
d={}
for i in range(0,16):
    if(i>=10):
        d[chr(55+i)]=bin(i).replace("0b","")
    else:
        d[str(i)]=(4-len(bin(i).replace("0b","")))*"0"+(bin(i).replace("0b",""))
n=int(input())
arr=[""]*(n)
for i in range(n):
    st=input()
    for j in st:
        arr[i]+=d[j]

arr.append("fe")
count = 1
mini = 0
store1=[]
for i in range(n):
    if (arr[i] == arr[i + 1]):
        count += 1
    else:
        store1.append(count)
        count = 1
store2 = []
length = 1
for i in range(1,n):
    flag = True
    for j in range(n):
        if arr[j][i-1] != arr[j][i]:flag = False
    if flag: length += 1
    else: store2.append(length);length = 1
store2.append(length)
ans1 = store1[0]
for x in store1:
    ans1 = math.gcd(ans1, x)
ans2 = store2[0]
for y in store2:
    ans2 = math.gcd(ans2, y)
print(math.gcd(ans1,ans2))