n = input()
t = int(input())
beg = False
end = False

for __ in  range(t):

    q = input()

    if q == n:
        beg = True
        end = True
        print("YES")
        break
    if q.endswith(n[0]):
        beg = True
    if q.startswith(n[1]):
        end = True
    if beg == end and beg:
        print("YES")
        break
if not beg or not end:
    print("NO")
