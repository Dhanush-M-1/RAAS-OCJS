
board = []

for i in range(4):
    arr = [str(x) for x in input()]
    board.append(arr)
    
winner = False

def check(board):
    for n in range(4):
        for nums, item in enumerate(board[n]):
            if item  == '.':
                board[n][nums] = 'x'
                if (board[0][0]==board[0][1]==board[0][2]=='x' or
                    board[0][1]==board[0][2]==board[0][3]=='x' or
                    board[1][0]==board[1][1]==board[1][2]=='x' or
                    board[1][1]==board[1][2]==board[1][3]=='x' or
                    board[2][0]==board[2][1]==board[2][2]=='x' or
                    board[2][1]==board[2][2]==board[2][3]=='x' or
                    board[3][0]==board[3][1]==board[3][2]=='x' or
                    board[3][1]==board[3][2]==board[3][3]=='x' or

                    ### Vertical

                    board[0][0]==board[1][0]==board[2][0]=='x' or
                    board[1][0]==board[2][0]==board[3][0]=='x' or
                    board[0][1]==board[1][1]==board[2][1]=='x' or
                    board[1][1]==board[2][1]==board[3][1]=='x' or
                    board[0][2]==board[1][2]==board[2][2]=='x' or
                    board[1][2]==board[2][2]==board[3][2]=='x' or
                    board[0][3]==board[1][3]==board[2][3]=='x' or
                    board[1][3]==board[2][3]==board[3][3]=='x' or

                    ### Dioganal 

                    board[0][2]==board[1][1]==board[2][0]=='x' or
                    board[0][3]==board[1][2]==board[2][1]=='x' or
                    board[1][2]==board[2][1]==board[3][0]=='x' or
                    board[1][3]==board[2][2]==board[3][1]=='x' or

                    board[0][1]==board[1][2]==board[2][3]=='x' or
                    board[0][0]==board[1][1]==board[2][2]=='x' or
                    board[1][1]==board[2][2]==board[3][3]=='x' or
                    board[1][0]==board[2][1]==board[3][2]=='x'):
                    
                    print("YES")
                    return
                
                board[n][nums] = 'o'
    print('NO')
    return
                


    
check(board)