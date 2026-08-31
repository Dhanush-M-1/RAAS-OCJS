import sys
input = sys.stdin.readline

'''

'''

def get_max_index(a, left_index, right_index):
    mx = -1
    mx_index = None

    for index in range(left_index, right_index+1):
        if a[index] > mx:
            mx = a[index]
            mx_index = index
    
    return mx_index

def solve(n, a):
    res = [-1] * n

    def rec_solve(left_index, right_index, depth):
        if left_index > right_index:
            return
        
        index = get_max_index(a, left_index, right_index)
        #print("max index", index, "max value", a[index])
        res[index]= depth

        rec_solve(left_index, index-1, depth+1)
        rec_solve(index+1, right_index, depth+1)

    rec_solve(0, n-1, 0)
    return res

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    res = solve(n, a)
    print(*res)