import sys

# sys.stdin = open("E:\\programming\\New folder\\input.txt", "r")
# sys.stdout = open("E:\\programming\\New folder\\output.txt", "w")

ans = 0


def fun(p, key1, key2):
    k = 0
    global ans
    ans = 0
    for i in range(1, -1, -1):
        if int(st[k][i]) != key1:
            ans += 1
            p.append((k + 1, i + 1))
        k += 1
    k = n - 2
    for i in range(n-1, n - 3, -1):
        if int(st[k][i]) != key2:
            ans += 1
            p.append((k + 1, i + 1))
        k += 1


t = int(input())
for tc in range(t):
    # a = list(map(int, input().split()))
    n = int(input())
    st = list()
    for i in range(n):
        k = input()
        st.append(k)
    p = list()
    fun(p, 0, 1)
    if ans < 3:
        print(ans)
        for i in p:
            print(*i)
        continue
    p = list()
    fun(p, 1, 0)
    print(ans)
    for i in p:
        print(*i)
