n, k = map(int, input().split())
books = [list(map(int, input().split())) for i in range(n)]
AB, A, B = [[10**5,0,0]], [[10**5,0,0]], [[10**5,0,0]]
for t,a,b in books:
    if a == 1 and b == 1:
        AB.append([t,a,b])
    elif a == 1 and b == 0:
        A.append([t,a,b])
    elif a == 0 and b == 1:
        B.append([t,a,b])
AB = list(reversed(sorted(AB)))
A = list(reversed(sorted(A)))
B = list(reversed(sorted(B)))
ans = []
for i in range(k):
    if len(AB) != 1 and AB[-1][0] < A[-1][0] + B[-1][0]:
        ans.append(AB.pop()[0])
    elif len(A) != 1 and len(B) != 1:
        ans.append(A.pop()[0])
        ans.append(B.pop()[0])
    else:
        print(-1)
        break
else:
    print(sum(ans))