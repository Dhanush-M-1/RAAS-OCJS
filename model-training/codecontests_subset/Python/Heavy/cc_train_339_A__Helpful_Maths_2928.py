# towers = [[], [], []]
# ans = 0
# def hanoi(n, source, dest, aux):
#     if(n==1):
#         move(n, source, dest)
#     else:
#         hanoi(n-1, source, aux, dest)
#         move(n, source, dest)
#         hanoi(n-1, aux, dest, source)
#         # hanoi(n-1, aux, source, dest)

# def move(n, source, dest):
#     global towers, ans
#     ans += 1
#     towers[source].remove(n)
#     towers[dest] += [n]


# n = int(input())
# for i in range(1, n+1):
#     towers[0] += [i]
# hanoi(n, 0, 2, 1)
# print(towers, ans)

s = list(map(int, input().split("+")))
s.sort()
for i in range(len(s)):
    if(i!=len(s)-1):
        print(s[i], end = "+")
    else:
        print(s[i])
