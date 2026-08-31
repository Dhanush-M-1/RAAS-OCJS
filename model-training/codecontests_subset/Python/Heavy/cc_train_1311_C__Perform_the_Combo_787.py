t = int(input())

for i in range(t):
    n, m = map(int, input().split())
    letters = list(input())
    pressed = list(map(int, input().split()))
    
    alphabet = [0 for t in range(26)]

    numbers = [0 for t in range(n)]
    numbers[-1] = 1
    
    for number in pressed:
        numbers[number - 1] += 1

    mcopy = m + 1
    last = 0
    for j in range(n):
        if numbers[j]:
            for t in range(last, j + 1):
                alphabet[ord(letters[t]) % 97] += mcopy
            last = j + 1
            mcopy -= numbers[j]

    print(*alphabet)




    




