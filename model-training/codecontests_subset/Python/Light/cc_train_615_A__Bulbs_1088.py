n, m = map(int, input().split())
ar = []
for i in range(n):
                temp = [int(n) for n in input().split()]
                ar += temp[1:len(temp)]
check = 0
#print(ar)
for i in range(1, m + 1):
                if i in ar:
                                check += 1
                                if check == m:
                                                break
if check == m:
                print("YES")
else:
                print("NO")
                