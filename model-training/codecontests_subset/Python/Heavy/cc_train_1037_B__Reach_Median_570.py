a = input().split()
n = int(a[0])
s = int(a[1])
A = input().split()
for i in range(n):
    A[i] = int(A[i])
A.sort()
men, rav, bol, result = 0, 0, 0, 0
for i in range(n):
    if int(A[i]) < s:
        men += 1
    elif int(A[i]) == s:
        rav += 1
    else:
        bol += 1
if s < int(A[0]):
    for i in range((n + 1) // 2):
        result += (int(A[i]) - s)
elif s > int(A[-1]):
    for i in range((n + 1) // 2 - 1, n):
        result += (s - int(A[i]))    
elif men >= (n + 1) // 2:
    for i in range((n + 1) // 2, men + 1):
        result += (s - int(A[i - 1]))
elif bol >= (n + 1) // 2:
    for i in range(men + rav + 1, (n + 1) // 2 + 1):
        result += (int(A[i - 1]) - s)
print(result)