from collections import defaultdict

N, X, MyDict, MyString = int(input()), input(), defaultdict(int), ""
if N > len(X):
    print(-1)
    exit()
for i in X:
    MyDict[i] += 1
for i in MyDict.values():
    if i % N != 0:
        print(-1)
        exit()
for i in MyDict.keys():
    MyString += i * (MyDict[i]//N)
print(MyString*N)

# UB_CodeForces
# Advice: Never give up because the great things take time
# Location: At home behind my desk next to my information retrieval notes
# Caption: My puffy face because of a hit
# CodeNumber: 484
