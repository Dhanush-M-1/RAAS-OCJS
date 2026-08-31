n, k = map(int, input().split(" "))
a = list(map(int, input().split(" ")))
print(int(min([k/x for x in list(filter(lambda x: k%x == 0, a))])))