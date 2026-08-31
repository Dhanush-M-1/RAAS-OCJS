tmp = input().split()
n= int(tmp[0])
k = int(tmp[1])
tmp = input().split()
tree = [ list() for i in range(200001) ]
minlength = 2000001
for value in tmp:
    value = int(value)
    length = 0
    while(value != 0):
        if len(tree[value]) < k:
            tree[value].append(length)
            if len(tree[value]) == k and minlength > sum(tree[value]):
                minlength = sum(tree[value])
        else:
            if max(tree[value]) > length:
                tree[value].remove(max(tree[value]))
                tree[value].append(length)
                if minlength > sum(tree[value]):
                    minlength = sum(tree[value])
        value = value // 2
        length += 1
print(minlength)