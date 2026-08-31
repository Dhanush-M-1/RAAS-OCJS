def depth_perm(tree, level):
    if(len(tree) == 0):
        return []
    else:
        max_elem = max(tree)
        i = tree.index(max_elem)
        half1 = tree[:i]
        half2 = tree[i+1:]
        return (depth_perm(half1, level+1) + [level] + depth_perm(half2, level+1))

enter = int(input())

for i in range(enter):
    length = input()
    permutation = list(map(int, input().split()))
    array = depth_perm(permutation, 0)
    output = ""
    for o in array:
        output += (str(o) + " ")
    print(output)