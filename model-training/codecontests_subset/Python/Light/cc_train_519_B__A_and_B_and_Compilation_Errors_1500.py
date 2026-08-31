s = input()
w = input().split(' ')
t = input().split(' ')
v = input().split(' ')

w = sorted(w)
t = sorted(t)
v = sorted(v)

for i in range(len(w)):
    if i == len(t):
        print(w[i])
        break
    if w[i] != t[i]:
        print(w[i])
        break

for i in range(len(t)):
    if i == len(v):
        print(t[i])
        break
    if t[i] != v[i]:
        print(t[i])
        break