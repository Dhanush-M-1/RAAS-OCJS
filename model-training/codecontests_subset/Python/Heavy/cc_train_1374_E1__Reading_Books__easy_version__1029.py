# stdin = open("testdata.txt")
# def input():
#     return stdin.readline().strip()

def addition(lst,k):
    lst_alice = []
    lst_bob = []
    lst_both = []
    addition_lst = []
    lst.sort()
    for i in range(len(lst)):
        if lst[i][1] == 1 and lst[i][2] == 0:
            lst_alice.append(lst[i])
        elif lst[i][1] == 0 and lst[i][2] == 1:
            lst_bob.append(lst[i])
        elif lst[i][1] == 1 and lst[i][2] == 1:
            lst_both.append(lst[i])
    n = min(len(lst_alice),len(lst_bob))
    addition_lst = [ [lst_alice[i][j]+lst_bob[i][j] for j in range(3)] for i in range(n)]
    lst_both.extend(addition_lst)
    lst_both.sort()
    if len(lst_both) < k:
        return -1
    ret = 0
    for i in range(k):
        ret += lst_both[i][0]
    return ret

    
n ,k = map(int,input().split())
lst = []
for _ in range(n):
    lst.append(list(map(int,input().split())))
print(addition(lst, k))

