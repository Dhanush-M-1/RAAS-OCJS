tcases = int(input())

for i in range(tcases):
    alen = int(input())
    a = [int(x) for x in input().split(' ')]
    max_ = -1000000010
    min_ = 1000000010
    for i in range(alen):
        if a[i] == -1:
            if i > 0:
                if a[i - 1] != -1:
                    max_ = max(max_, a[i-1])
                    min_ = min(min_, a[i-1])
            if i < alen - 1:
                if a[i + 1] != -1:
                    max_ = max(max_, a[i+1])
                    min_ = min(min_, a[i+1]) 
#        print(max_, min_)
#    for i in range(alen):
#        if i > 0 and a[i] == -1 and a[i-1] != -1:
#            min_ = min(min_, a[i-1])
#            max_ = max(max_, a[i-1])
#        if i < alen-1 and a[i] == -1 and a[i+1] != -1:
#            min_ = min(min_, a[i+1])
#            max_ = max(max_, a[i+1])
    k = (max_ + min_) // 2
    a = [x if x != -1 else k for x in a ]
    m = 0
    for i in range(alen - 1):
        m = max(m, abs(a[i] - a[i + 1]))
    
    print(m, ' ' , k)