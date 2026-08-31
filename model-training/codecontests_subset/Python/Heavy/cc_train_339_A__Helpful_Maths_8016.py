
def answer(a):
    list = []
    x = []
    b= ''
    if len(a) < 2:
        print(a)
        return
    for i in range(0,len(a),2):
        list.append(a[i])
    sorting(list)
    for i in range(len(list)):
        b = b + list[i]
        if i < len(list)-1:
            b = b + '+'
    print(b)
def sorting(list):
    for i in range(len(list)):
        min = len(list) - 1
        for j in range(i,len(list)):
            if list[j] < list[min]:
                min = j

        temp = list[i]
        list[i] = list[min]
        list[min] = temp
    return list

if __name__ == "__main__":
    a = input(" ")
    answer(a)