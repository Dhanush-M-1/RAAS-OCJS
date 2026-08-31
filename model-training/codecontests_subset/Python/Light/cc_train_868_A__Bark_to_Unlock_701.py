passw = list(input())
t = int(input())
barked=""
done=0
first,second=[],[]
for x in range(t):
    l1 = list(input())
    if passw==l1:
        done=1
        break
    first.append(l1[0])
    second.append(l1[1])

if done or passw[0] in second and passw[1] in first:
    print("YES")
else:
    print("NO")