

test_cases = int(input())
for t in range(test_cases):
    n_records = int(input())
    records = []
    for r in range(n_records):
        records.append(tuple(map(int, input().split())))

    play, clear = records[0]
    if clear > play:
        print("NO")
        continue

    for idx, (play, clear) in enumerate(records[1:], start=1):
        if clear > play:
            print("NO")
            break
        prev_play, prev_clear = records[idx-1]

        if not((play >= prev_play) and (clear >= prev_clear) and (clear-prev_clear <= play - prev_play)):
            print("NO")
            break
    else:
        print("YES")


