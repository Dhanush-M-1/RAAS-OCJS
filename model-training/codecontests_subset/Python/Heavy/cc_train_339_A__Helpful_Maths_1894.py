def orderSummands():
    summands = input()
    nonDecreasingOrder = removeSummands(summands)
    printToConsole(nonDecreasingOrder)


def removeSummands(summands):
    summandsList = summands.split('+')
    for i in range(len(summandsList) - 1):
        for j in range(len(summandsList) - i - 1):
            if summandsList[j + 1] < summandsList[j]:
                summandsList[j], summandsList[j + 1] = summandsList[j + 1], summandsList[j]
    return summandsList


def printToConsole(nonDecreasingOrder):
    print('+'.join(nonDecreasingOrder))


if __name__ == '__main__':
    orderSummands()
