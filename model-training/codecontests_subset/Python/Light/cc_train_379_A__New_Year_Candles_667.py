raw, recycle = map(int, input().split())
answer = raw
burnt = raw
while burnt//recycle != 0:
    answer += burnt//recycle
    burnt = burnt//recycle + burnt%recycle
print(answer)