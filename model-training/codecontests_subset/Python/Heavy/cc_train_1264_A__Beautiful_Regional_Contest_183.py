for _ in range(0, int(input())):
    n = int(input())
    pro = list(map(int, input().split(" ")))
    med = int(n/2)
    mini = pro[n-1]
    est = "G"
    g = 0
    s = 0
    b = 0

    if len(set(pro)) >= 4:
        for i in range(0, med):
            if est == "G":
                g += 1
            elif est == "S":
                s += 1
            elif est == "B" and pro[i] > mini:
                if pro[i] != pro[med-1] or pro[med-1] > pro[med]:
                    b += 1
            if pro[i] > pro[i+1] and est == "G":
                est = "S"
            elif pro[i] > pro[i + 1] and est == "S" and g < s:
                est = "B"
    if g >= s or g >= b:
        g = s = b = 0

    print(str(g) + " " + str(s) + " " + str(b))



