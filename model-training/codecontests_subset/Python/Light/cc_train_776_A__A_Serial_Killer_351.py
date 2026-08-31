text = input().split()
print(*text)
for i in range(int(input())):
    a, b = input().split()

    text.remove(a)

    text.append(b)
    print(*text)