def main():
    jumlah_int = int(input())
    list_int = []
    numbers_unsplit = input()
    for i in numbers_unsplit.split(" "):
        list_int.append(int(i))
    parity_alternated_deletions(list_int)


def parity_alternated_deletions(list_int):
    list_even = []
    list_odd = []
    for i in list_int:
        if(i % 2 == 0):
            list_even.append(i)
        else:
            list_odd.append(i)
    if(len(list_even) == len(list_odd)):
        print("0")
    elif(len(list_even) > len(list_odd)):
        count = 0
        diff = len(list_even) - len(list_odd)
        for i in range(diff-1):
            min_val = list_even[0]
            index_val = 0
            for j in range(1, len(list_even)):
                if(min_val > list_even[j]):
                    min_val = list_even[j]
                    index_val = j
            count += min_val
            list_even.pop(index_val)
        print(count)
    else:
        count = 0
        diff = len(list_odd) - len(list_even)
        for i in range(diff-1):
            min_val = list_odd[0]
            index_val = 0
            for j in range(1, len(list_odd)):
                if(min_val > list_odd[j]):
                    min_val = list_odd[j]
                    index_val = j
            count += min_val
            list_odd.pop(index_val)
        print(count)
main()