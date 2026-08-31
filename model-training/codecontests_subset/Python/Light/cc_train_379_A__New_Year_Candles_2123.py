a, b = map(int, input().split())
add = 0
while (a+add)//b != add:
    add = (a+add)//b
print(a+add)