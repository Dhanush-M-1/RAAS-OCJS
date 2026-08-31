

def solve(n, m, a, b):
    a_logs = set()
    b_logs = set()
    for i in a:
        a_logs.add(i)
    arr = []
    for i in b:
        if i in a_logs:
            arr.append(i)
            break
    
    if len(arr):
        print('YES')
        print(len(arr), *arr)
    else:
        print('NO')

        






if __name__ == '__main__':
    for t in range(int(input())):
        n, m = map(int, input().split())
        a = list(map(int, input().split()))
        b = list(map(int, input().split()))
        solve(n ,m, a, b)