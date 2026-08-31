n = int(input())
if n > 2:
    count  = 2
    tree_list = [list(int(x) for x in input().split()) for i in range(n)]
    for i in range(1,n-1):
        if tree_list[i][1] <= (tree_list[i][0] - tree_list[i-1][0] - 1):
            count += 1
        elif tree_list[i][1] <= (tree_list[i+1][0] - tree_list[i][0] - 1):
            count += 1
            tree_list[i][0] += tree_list[i][1]
    print(count)
else:
    print(n)
