n = int(input())
tree_nums = [0 for i in range(n)]
for i in range(n - 1):
    a1, a2 = map(int, input().split())
    tree_nums[a1 - 1] += 1
    tree_nums[a2 - 1] += 1
if n == 2:
    print('YES')
elif n == 3:
    print('NO')
else:
    ans_is_no = False
    for i in range(n):
        if tree_nums[i] == 2:
            ans_is_no = True
            print('NO')
            break
    if not ans_is_no:
        print('YES')