x = input()
n = int(input())
start = set()
end = set()

a = ''
hasFound = 0
for i in range(n):
    t = input()
    if x == t:
        hasFound = 1
        print('YES')
        break
    start.add(t[0])
    end.add(t[1])

start = list(start)
end = list(end)
if not hasFound:
    if x[0] in end  and x[1] in start:
        print("YES")
    else:
        print("NO")
