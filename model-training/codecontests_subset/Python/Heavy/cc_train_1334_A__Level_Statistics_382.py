import itertools
test = int(input())
out_ = []
for _ in range(test):
    n = int(input())
    p_list = []
    c_list = []
    for i in range(n):
        a,b = map(int,input().split(' '))
        p_list.append(a)
        c_list.append(b)

    flag = 0
    last_a = 0
    last_b = 0
    diff_a = 0
    diff_b = 0
    for (a, b) in zip(p_list,c_list):
        diff_a = a-last_a
        diff_b = b-last_b

        if b<=a and diff_b<=diff_a:
            if a>=last_a and b>=last_b:
                last_a = a
                last_b = b
            else:
                flag = 1
                break
        else:
            flag = 1
            break
    if flag==0:
        out_.append("YES")
    else:
        out_.append("NO")
for o in out_:
    print(o)
    # for a,b in list(zip(p_list,c_list)):
    #     if b<=a:
    #         if 
