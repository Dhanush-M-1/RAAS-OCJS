def sweet_home(array, key):
    for i in array:
        for x in array:
            new_1 = i + x
            new_2 = x + i
            if new_1.find(key) != -1 or new_2.find(key) != -1:
                return("YES")
    return("NO")

password = str(input())
n = int(input())
words = []

for i in range(0, n):
    words.append(str(input()))

print(sweet_home(words, password))