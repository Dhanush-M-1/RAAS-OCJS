def main():

    n = (int)(input())

    firstList = list(map(int, input().split()))
    secondList = list(map(int, input().split()))
    thirdList = list(map(int, input().split()))

    firstList.sort()
    secondList.sort()
    thirdList.sort()

    listErros(n, n - 1, firstList, secondList)
    listErros(n - 1, n - 2, secondList, thirdList)

def listErros(n1, n2, list1, list2):

    i = 0
    out = 0

    while(i < n1 and out == 0):

        if(i < n2 and list1[i] != list2[i]):

            print(list1[i])
            break

        elif(i >= n2):

            print(list1[i])
            break

        i += 1

if __name__ == '__main__':
    main()
   	 		 	 	   		 				 		   			