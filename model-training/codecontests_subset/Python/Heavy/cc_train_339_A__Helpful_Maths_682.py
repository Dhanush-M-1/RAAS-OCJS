def helpfulMaths(str):
    arr = []
    stg = ""
    
    for s in range(len(str)):
        arr.append(str[s])

    for a in range(0, len(arr)):
        if(arr[a] != '+'):
            for b in range(0, len(arr)):
                if(arr[b] != '+'):
                    if(arr[a] < arr[b]):
                        temp = arr[a]
                        arr[a] = arr[b]
                        arr[b] = temp
    for a in arr:
        stg += a
    print(stg)

if __name__ == "__main__":
    helpfulMaths(input())
    #helpfulMaths("3+2+1")