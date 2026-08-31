def main():
    inp = input()
    nums = [0, 0, 0]
    for i in range(len(inp)//2 + 1):
        nums[int(inp[2*i])-1] += 1
    out = ''
    if nums[0] != 0:
        out += '1' + '+1'*(nums[0]-1)
    if nums[1] != 0:
        if out == '':
            out += '2' + '+2'*(nums[1]-1)
        else:
            out += '+2'*nums[1]
    if nums[2] != 0:
        if out == '':
            out += '3' + '+3'*(nums[2]-1)
        else:
            out += '+3'*nums[2]
    print(out)

if __name__ == '__main__':
    main()
