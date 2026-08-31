n = int(input())
shirts = []


def check(index, end, shirts):

    result = 0
    if end >= len(shirts):
        return 0
    else:
    
        if shirts[index][0] == shirts[end][1]:
            result += 1
        if shirts[index][1] == shirts[end][0]:
            result += 1
        return result + check(index, end+1, shirts)

for i in range(n):
    shirts.append(list(input().split()))

#print(check(0, 1, shirts))

result = 0

for i in range(n):
    result += check(i, i+1, shirts)
print(result)
