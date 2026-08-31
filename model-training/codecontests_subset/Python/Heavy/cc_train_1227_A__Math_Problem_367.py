t_sets = int(input())
low = 'a'
high = 'b'

for i in range(0, t_sets):
    n_cuts = int(input())
    list_of_cuts = []
    for i in range(0, n_cuts):
        cut1 = input()
        cut = [int(x) for x in cut1.split(' ')]
        list_of_cuts.append(cut)
    if len(list_of_cuts) > 1:
        for cut in list_of_cuts:
            if low == 'a':
                low = cut[1]
            if cut[1] < low:
                low = cut[1]
            if high == 'b':
                high = cut[0]
            if cut[0] > high:
                high = cut[0]
        if high > low:
            print(high-low)
        else:
            print(0)
    else:
        print(0)
    low = 'a'
    high = 'b'