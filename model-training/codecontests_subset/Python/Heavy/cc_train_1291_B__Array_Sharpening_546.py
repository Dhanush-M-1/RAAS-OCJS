cases = int(input())

def operate():
    input()
    arr = [int(a) for a in input().strip().split()]
    yes = True
    neg_start = False
    for i, v in enumerate(arr):
        # print(i, v)
        if not (v >= i):
            neg_start = True
        # print(neg_start)
        if neg_start:
            if not (v >= len(arr) - i - 1) or ((v == len(arr) -i - 1) and (i != 0 and v == arr[i - 1])):
                print("NO")
                yes = False
                break
    if yes:
        print("YES")
        


for _ in range(cases):
    operate()

