def main():
    x = eval(input())
    check = True
    list1 = [True,True,True,False]
    for i in range(x):
        win = eval(input())
        if list1[win] == False:
            check = False
            continue
        for j in [1,2,3]:
            if win != j and list1[j] == list1[win]:
                lose = j
        for j in [1,2,3]:
            if j != win and j != lose:
                list1[j] = True
        list1[lose] = False
    
    if check:
        print("YES")
    else:
        print("NO")
main()
