tanka = (5, 7, 5, 7, 7, 0)
words = list()
n = int()

def rec(step, itr, word):
    if step == 5:
        return True

    if word == 0:
        return rec(step + 1, itr, tanka[step + 1])
    elif word < 0:
        return False
    
    return rec(step, itr + 1, word - words[itr])

while True:
    n = int(input())
    if n == 0:
        break

    words = [len(str(input())) for i in range(n)]
    for i in range(n):
        if rec(0, i, tanka[0]):
            print(i + 1)
            break
