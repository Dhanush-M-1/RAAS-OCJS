def printSolution(array):
    if len(array) >= 3:
        if array[0] + array[1] <= array[-1]:
            print(1, 2, len(array))
            return
    print(-1)

def submit():
    for case in range(int(input())):
        input()
        array = [int(e) for e in input().split()]
        printSolution(array)

submit()
