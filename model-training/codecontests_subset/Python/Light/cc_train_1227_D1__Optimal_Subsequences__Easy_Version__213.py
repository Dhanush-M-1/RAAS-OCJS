m = int(input())
line = [int(i) for i in input().split()]
for i in range(int(input())):
    false_line = list(line)
    k, pos = map(int, input().split())
    while len(false_line) > k:
        x = min(false_line)
        rang = iter(range(-1, -len(false_line)-1, -1))
        j = next(rang)
        while j > -len(false_line)-1:
            if false_line[j] == x:
                del false_line[j]
                if len(false_line) == k:
                    break
            else:
                try:
                    j = next(rang)
                except StopIteration:
                    break
    print(false_line[pos-1])
