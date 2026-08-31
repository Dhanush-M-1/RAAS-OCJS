def main():
    cused = 0
    hours = 0
    cdisp = 0
    cused = 0
    ase = input()
    asee = ase.split(" ")
    a = int(asee[0])
    b = int(asee[1])
    cdisp += a
    while cdisp > 0:
        cused += 1
        cdisp -= 1
        hours += 1
        if(cused == b):
            cused -= b
            cdisp += 1
    print(hours)
main()