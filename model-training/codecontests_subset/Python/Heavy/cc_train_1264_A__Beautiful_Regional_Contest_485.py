from collections import Counter

t = int(input())
for _ in range(t):
    n = int(input())
    p = list(map(int, input().split()))
    c = Counter(p)
    problem_classes = sorted(c.keys(), reverse=True)
    if len(problem_classes) < 4:
        print("0 0 0")
        continue
    gold = c[problem_classes[0]]
    silver, i = 0, 1
    while silver <= gold and i < len(problem_classes):
        silver, i = silver + c[problem_classes[i]], i + 1
    bronze = 0
    while bronze <= gold and i < len(problem_classes):
        bronze, i = bronze + c[problem_classes[i]], i + 1
    if gold + silver + bronze > n // 2:
        print("0 0 0")
        continue
    else:
        while i < len(problem_classes):
            if gold + silver + bronze + c[problem_classes[i]] <= n // 2:
                bronze, i = bronze + c[problem_classes[i]], i + 1
            else:
                break
    print(gold, silver, bronze)
