#include <cstdio>

int main(){
    int n,m;
    char suit,suits[4]={'S','H','C','D'};
    int cards[4][13] = {0};

    scanf("%d\n",&n);
    // printf("n:%d\n",n);
    for(int i = 0;i<n;i++){
        scanf("%c %d\n",&suit,&m);
        // printf("read:%c %d\n",suit,m);
        for(int j = 0; j< 4; j++){
            if(suit == suits[j])cards[j][m-1] = 1;
        }
    }
    for(int i = 0;i<4;i++){
        for(int j = 0;j<13;j++){
            if(!cards[i][j])printf("%c %d\n",suits[i],j+1);
        }
    }
    return 0;
}
