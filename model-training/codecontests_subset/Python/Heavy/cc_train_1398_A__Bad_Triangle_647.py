# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.

def check(arrayList):
    result = "-1"
    if arrayList[0] + arrayList[1] <= arrayList[len(arrayList)-1]:
        last_index = str(len(arrayList))
        result = "1 2 "
        result = result + last_index

    print(result)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    # print_hi('PyCharm')
    t = int(input())
    for i in range(0, t):
        n = int(input())
        lists = list(int(num) for num in input().strip().split())[:n]
        check(lists)
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
