res = ''
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    if a[n-1] >= a[0] + a[1]: res += f'1 2 {n}\n'
    else: res += '-1\n'
print(res)