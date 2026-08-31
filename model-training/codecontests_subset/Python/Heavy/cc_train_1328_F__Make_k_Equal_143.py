def main():
    n,k = map(int,input().split())
    aa = [int(a) for a in input().split()]
    vals = list(zip(aa,[0]*n))
    for a in aa:
        i = 0
        while a > 0:
            i+=1
            a = a//2
            vals.append((a, i))
    vals.sort()
    val = -1
    min = 20*k
    for a,i in vals:
        if a != val:
            vcount = 1
            vsum = i
            val = a
        elif vcount < k:
            vcount += 1
            vsum += i
        if vcount == k and vsum < min:
            min = vsum
    print(min)

if __name__ == "__main__":
    main()