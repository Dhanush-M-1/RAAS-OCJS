from collections import defaultdict

MyDict = defaultdict(int)
input()
for i in input():
    MyDict[i] += 1
print((0 if "A" not in MyDict.keys() else MyDict["A"]) if "I" not in MyDict.keys() else (0 if MyDict["I"] != 1 else 1))

# UB_CodeForces
# Advice: Falling down is an accident, staying down is a choice
# Location: Here in Bojnurd
# Caption: So Close man!! Take it easy!!!!
# CodeNumber: 650
