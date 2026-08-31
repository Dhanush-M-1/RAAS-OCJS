m , n = input().split()
x = []
for i in range(int(m)):
    t = input().split()
    x += t[1:]
for v in range(1,int(n)+1):
    if str(v) in x:
        continue
    else:
        print('NO')
        break
else:
    print('YES')