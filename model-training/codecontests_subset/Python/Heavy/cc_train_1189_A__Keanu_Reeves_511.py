n = int(input())

stream = list(input())

info = list()
val = 0
index = 0
for x in stream:
    
    if(index == 0):
        if(x == "0"):
            info.append(1)
        else:
            info.append(-1)
    else:
        if(x == "0"):
            info.append(info[index-1] + 1)
        else:
            info.append(info[index-1] - 1)
    index = index + 1

#print(info)
#[-1, 0, 1, 2, 1, 0]
ans = dict()
if(info[n-1] != 0 ):
    ans["val"] = 1
    ans["str"] = stream
else:
    ans["val"] = 2
    ans["str"] = stream[0:n-1] + [" "] + stream[n-1:n]

print(ans["val"])
print("".join(ans["str"]))