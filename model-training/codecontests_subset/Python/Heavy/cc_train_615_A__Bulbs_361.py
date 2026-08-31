def solve(bulbs):

    for bulb in bulbs:
        if bulb is 0:
            return "NO"

    return "YES"

if __name__ == "__main__":
    n,m = map(int, input().split(" "))

    bulbs = [0] * m #array sized for m bulbs
    for _n in range(0, n):
        vals = list(map(int, input().split(" ")))
        vals.pop(0) #first value in the list is that of switch, don't need that in solving
        for bulbIdx in vals:
            bulbs[bulbIdx-1] = 1 #-1 since bulb numbers are indexed from 1, opposed to 0 in arrays

    print(solve(bulbs))
