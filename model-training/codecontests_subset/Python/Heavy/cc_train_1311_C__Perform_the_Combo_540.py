testcases=int(input())

for j in range(testcases):
    values=list(map(int,input().split()))
    lengthofstring=values[0]
    numtries=values[1]
    string=[ord(q)-97 for q in input()]
    listtries=list(map(int,input().split()))
    dummylist=[0 for alpha in range(26)]
    storedict={}
    answerlist=[0 for alpha in range(26)]
    for k in range(lengthofstring):
        dummylist[string[k]]+=1
        storedict[k+1]=dummylist+[]
    listtries.append(lengthofstring)
    for l in range(numtries+1):
        values2=storedict[listtries[l]]
        for j in range(26):
            answerlist[j]+=values2[j]
    print(" ".join(list(map(str,answerlist))))