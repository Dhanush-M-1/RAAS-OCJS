def solve():

    password = input()
    n = int(input())
    words = [input() for i in range(n)]

    #status = "NO"
    for i in range(n):
        for j in range(n):
            temp = words[i] + words[j]
            if password in temp:
                return "YES"
    return "NO"

print(solve())
