n, k = map(int, input().split())
bacterias = {}
for el in list(map(int, input().split())):
    if el not in bacterias.keys():
        bacterias.update({el: [1, 1]})
    else:
        bacterias[el][0] += 1
bacterias_weights = list(bacterias.keys())
bacterias_weights.sort()
for j in range(len(bacterias_weights)):
    for i in range(j, len(bacterias_weights)):
        if bacterias_weights[i] > bacterias_weights[j]+k:
            break
        if bacterias_weights[j] < bacterias_weights[i] <= bacterias_weights[j] + k:
            bacterias[bacterias_weights[j]][1] = 0
            break
count = 0
for bacteria in bacterias.keys():
    if bacterias[bacteria][1]:
        count += bacterias[bacteria][0]
print(count)