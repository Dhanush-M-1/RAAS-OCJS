n = int(input())
error1 = list(map(int, input().split()))
error2 = list(map(int, input().split()))
error3 = list(map(int, input().split()))
error1.sort()
error2.sort()
error3.sort()
fix1 = False
for i in range(n-1):
    if error1[i] != error2[i]:
        fix1 = error1[i]
        break
if not fix1:
    fix1 = error1[-1]
fix2 = False
for i in range(n-2):
    if error2[i] != error3[i]:
        fix2 = error2[i]
        break
if not fix2:
    fix2 = error2[-1]
print(fix1)
print(fix2)