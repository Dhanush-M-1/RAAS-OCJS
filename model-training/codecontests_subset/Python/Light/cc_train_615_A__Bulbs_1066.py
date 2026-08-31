 
def solve():
    groups, lights = list(map(int, input().split(" ")))
    lst = []
 
    for i in range(groups):
        group = list(map(int, input().split(" ")))
        num = group.pop(0)
        lst = lst + group
    lst = list(set(lst))
    if len(lst) == lights:
        print("YES")
    else:
        print("NO")
 
 
solve()