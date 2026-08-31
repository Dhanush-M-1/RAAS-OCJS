pw = input()
n = int(input())
a = 0
b = 0
for i in range(n):
    x = input()
    if x==pw:
        a+=1
        b+=1
        break
    else:
        if x[0]==pw[1]:
            a+=1
        if x[1]==pw[0]:
            b+=1
print ('YES') if a>=1 and b>=1 else print('NO')
