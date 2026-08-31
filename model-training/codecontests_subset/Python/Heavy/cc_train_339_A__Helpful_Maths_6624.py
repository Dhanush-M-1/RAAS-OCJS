'''
# CodeForce Equalize Prices 900 points

# a = old price / b = new price / k =value input
def Computer_Game():

    for _ in range(int(input())):
        k, n, a, b = map(int, input().split())  # init charge, num turns in game, a,b bat value
        max_turns=0
        for turns in range(n):

            if k/b > n and (k-a)/b < n-1 and turns == 0:
                max_turns=0
                break
            else:
                if k > a:
                    k -= a
                    max_turns += 1
                elif k > b:
                    k -= b
                    if k/b == n-turns:
                        max_turns = 1
                        break
                else:
                    max_turns = -1
                    break


        print(max_turns)


    return


def bit_plus_plus():

    summe = 0
    for _ in range(int(input())):

        statement = input()
        if '+' in statement:
            summe += 1
        else:
            summe -= 1
    print(summe)
    return

def petya_and_strings():

    str_a, str_b = input().lower(), input().lower()
    a=(str_a<str_b)
    print((str_a>str_b)-(str_a<str_b))


    return




def beautiful_matrix():

    for idx in range(5):

        row_input = list(map(int,input().split()))
        if 1 in row_input:
            row = idx+1
            for idx1, elem in enumerate(row_input):
                if elem == 1:
                    column = idx1+1

    output = abs(3 - row) + abs(3 - column)
    print(output)
        #for row_num in range(4):
           # if 1 in row(row_num)

    return
'''

def helpful_maths():


    string = sorted(list(input().split('+')))
    print('+'.join(string))

    return

if __name__ == '__main__':

    helpful_maths()

'''
if __name__ == '__main__':
    num_queries = int(input())

    for querie in range(num_queries):
        num_products, value_products = map(int, input().split())
        price_products = list(map(int, input().split()))
        B_Max = min(price_products)+value_products
        B_Min = max(price_products)-value_products
        if B_Max >= B_Min:
            print(B_Max)
        else:
            print(-1)
'''






