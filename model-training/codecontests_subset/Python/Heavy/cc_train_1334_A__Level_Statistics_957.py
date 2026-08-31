def process():
    n = int(input())
    dt = [tuple(map(int, input().split())) for p in range(n)]
    for i in range(n):
        if dt[i][1] > dt[i][0]:
            return False
        if i < n-1:
            if (dt[i+1][1]-dt[i][1]) > (dt[i+1][0]-dt[i][0]):
                return False
            if min((dt[i+1][1]-dt[i][1]), (dt[i+1][0]-dt[i][0])) < 0:
                return False
    return True


'''
for _ in range(int(input())):
    print("YES" if process() else "NO")'''

print(*["YES" if process() else "NO" for i in range(int(input()))], sep="\n")
