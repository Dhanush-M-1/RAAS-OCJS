_ = input()
l = []
for i in range(3):
    aux = []
    aux = map(int, input().split())
    l.append(sum(aux))
print(l[0] - l[1])
print(l[1] - l[2])
# 1518212419099
