def main():

    n = (int)(input())
    s = input()

    list = []
    findIndex = []
    lenList = 0

    for i in range(1, n):

        tg = s[i - 1] + s[i]

        lenList, list, findIndex = findElement(list, findIndex, tg, lenList)

    print(list[findIndex.index(max(findIndex))])

def findElement(list, findIndex, tg, lenList):

    if (tg in list):

        findIndex[list.index(tg)] += 1

        return lenList, list, findIndex

    findIndex.append(1)
    list.append(tg)
    lenList += 1

    return lenList, list, findIndex

if __name__ == '__main__':
    main()
 	 			   				  		  			  		