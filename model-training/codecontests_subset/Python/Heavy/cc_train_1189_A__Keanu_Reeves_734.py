n = int(input())
s = input()
q1 = []
q0 = []
if s[0] == '1':
    q1.append(1)
    q0.append(0)
else:
    q1.append(0)
    q0.append(1)
for i in range(1, n):
    if s[i] == '1':
        q1.append(q1[i - 1] + 1)
        q0.append(q0[i - 1])
    else:
        q1.append(q1[i - 1])
        q0.append(q0[i - 1] + 1)
if q1[-1] != q0[-1]:
    print(1)
    print(s)
    exit(0)
for i in range(n):
    if q1[i] != q0[i]:
        if q1[n - 1] - q1[i] != q0[n - 1] - q0[i]:
            print(2)
            print(s[:i + 1], s[i + 1:])
            break
