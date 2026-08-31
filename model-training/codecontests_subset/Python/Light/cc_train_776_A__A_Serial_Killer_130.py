v = input().split(' ')
print(* v)
n = int(input())
for i in range(n):
    w = input().split(' ')
    v.remove(w[0])
    v.append(w[1])
    print(*v)