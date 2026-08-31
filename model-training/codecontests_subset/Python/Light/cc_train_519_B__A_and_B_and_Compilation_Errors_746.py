list1 = None


def error(lis, n) :
    global list1
    if list1 is None :
        list1 = lis[:]

    else :
        for i in range (n) :
             if list1[i] != lis[i] :
                 val = (list1[i])
                 list1 = lis[:]
                 break
             elif (len(list1) > n):
                val = list1[len(list1)-1]
                list1.pop (len (list1)-1)
        return val


if __name__ == "__main__" :
    ans = []
    num = int (input ( ))
    for i in range (3) :
        liss = sorted(list(map(int, input().split())))
        ans.append (error (liss, len(liss)))
    for j in range(1,3):
         print(ans[j])