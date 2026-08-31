
def main():
    n = int(input())
    cards = input()
    
    et_count = cards.count("8")
    ph_no = n // 11

    if et_count <= ph_no:
        print(et_count)
    elif ph_no <= et_count:
        print(ph_no)
    else:
        print(0)

if __name__ == "__main__":
    main()