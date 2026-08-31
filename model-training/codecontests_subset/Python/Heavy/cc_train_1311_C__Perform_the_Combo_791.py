import collections
def countLetters(S, tries):
    count = [0]*26

    i = 0
    counter = collections.defaultdict(tuple)
    for i, ch in enumerate(S):
        count[ord(ch) - ord('a')] += 1
        counter[i] = tuple(count)
        
    for j in tries:
        for i, c in enumerate(counter[j - 1]):
            count[i] += c
        
    for val in count:
        print(val, end = ' ')
    print()


testCases = int(input())
for _ in range(testCases):
    n, m = map(int, input().split())
    S = input()
    tries = [int(val) for val in input().split()]
    countLetters(S, tries)