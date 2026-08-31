k = input()
n = int(k)
p = [sorted(int(i) for i in input().split())]
s =p[0]
x, y =0 ,0

for i in s:
        if i <=(5*pow(10,5)):
            x = i-1
        else:
            y = pow(10,6)-i
            break
print(max(x,y))
