def common_member(a, b): 
    a_set = set(a) 
    b_set = set(b) 
    if (a_set & b_set): 
        return True 
    else: 
        return False

if __name__=="__main__":
    t = int(input())

    nums = []

    for i in range(t):
        n_m = [int(x) for x in input().split()]
        nums.append([])
        nums[-1].append([int(x) for x in input().split()])
        nums[-1].append([int(x) for x in input().split()])

    output = []

    for num in nums:
        a = num[0]
        b = num[1]
        common = list(set(a).intersection(b))
        if len(common) > 0:
            output.append(['YES', [1, common[0]]])
        else:
            output.append(['NO'])
    for out in output:
        if out[0] == 'YES':
            print(out[0])
            print(*out[1])
        else:
            print(out[0])