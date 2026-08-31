l = input().split()
n = int(input())
answ = [l.copy()]
for i in range(n):
    buf  = input().split()
    l.remove(buf[0])
    l.append(buf[1])
    answ.append(l.copy())
for j in range(n + 1):
    print(answ[j][0], answ[j][1])
