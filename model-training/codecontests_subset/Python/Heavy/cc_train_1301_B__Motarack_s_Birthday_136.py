

def MinimalReplacement(data):
    boundr = []
    mindif = 0
    for index in range(len(data)):
        if index != 0 and data[index] != -1 and data[index-1] != -1 and abs(data[index] - data[index - 1]) > mindif:
            mindif = abs(data[index] - data[index - 1])
        if index != 0 and data[index] == -1 and data[index - 1] != -1:
            boundr.append(data[index - 1])
        if index != len(data) - 1 and data[index] == -1 and data[index + 1] != -1:
            boundr.append(data[index + 1])
    if boundr:
        return max(mindif, (max(boundr) - min(boundr) + 1) // 2), (max(boundr) + min(boundr)) // 2
    else:
        return mindif, 0

if __name__ == "__main__":
    tests = int(input())
    for i in range(tests):
        trash = input()
        data = list(map(int, input().split()))
        d, k = MinimalReplacement(data)
        print(d, " ", k)
