INPUT = input()
lmpCount = int(INPUT.split(" ")[1])
btnCount = int(INPUT.split(" ")[0])
arr = []
for i in range(0,btnCount):
	arr.append(input())
possibleLmp = []
stri = arr[0][2:]
for i in arr:
        if (i[0]=='0'):
            continue
        buf = i.split(" ")
        buf.pop(0)
        possibleLmp.extend(buf)
possibleLmp = list(dict(zip(possibleLmp, possibleLmp)).values())
if (len(possibleLmp) == lmpCount):
        print("YES")
else:
        print("NO")
