from collections import Counter

def solve(arr):
    mapper = Counter(arr)
    max_medals = len(arr)//2
    if max_medals < 3:
        return [0, 0, 0]
    medals = [0, 0, 0]
    medals[0] = mapper[arr[0]]
    bound = mapper[arr[0]]
    while medals[1] <= medals[0] and sum(medals) <= max_medals:
        medals[1] += mapper[arr[bound]]
        bound += mapper[arr[bound]]
    while bound < len(arr) and sum(medals)+mapper[arr[bound]] <= max_medals:
        medals[2] += mapper[arr[bound]]
        bound += mapper[arr[bound]]
    if medals[0] >= medals[2]:
        return [0,0,0]
    return medals



if __name__ == '__main__':
    tests = int(input())
    res = []
    for i in range(tests):
        input()
        inp = list(map(int, input().split()))
        res.append(' '.join(list(map(str, solve(inp)))))
    print('\n'.join(res))