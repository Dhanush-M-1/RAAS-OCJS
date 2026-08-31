from collections import Counter

getListInput = lambda: list(map(int, input().split()))

NC, NQ = getListInput()
CS = getListInput()

COUNTER = Counter(CS)
POWERS = [COUNTER[2**i] if 2**i in COUNTER else 0 for i in range(30)]

ANSWER = []

for _ in range(NQ):
    QT = int(input())
    
    MIN = 0
    for p in reversed(range(30)):
        coins = min(QT//(2**p), POWERS[p])
        MIN += coins
        QT -= coins*(2**p)

    ANSWER.append(MIN if QT == 0 else -1)

print(" ".join(map(str, ANSWER)))
