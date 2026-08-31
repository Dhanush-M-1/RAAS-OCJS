inp = input().split(" ")
nam = []
nam.append(inp[0])
nam.append(inp[1])
final = []
final.append(nam)
n = int(input())
for i in range(n):
    name = final[-1].copy()
    k = input().split(" ")
    if name[0] == k[0]:
        name[0] = k[1]
    else:
        name[1] = k[1]
    
    final.append(name)
for i in final:
    print(*i)

