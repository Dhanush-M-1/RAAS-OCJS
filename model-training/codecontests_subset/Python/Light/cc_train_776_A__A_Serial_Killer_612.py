one, two = input().split()
print(one, two)
n = int(input())
for i in range(n):
    kill, new = input().split()
    if kill == one:
        one = new
    else:
        two = new
    print(one, two)