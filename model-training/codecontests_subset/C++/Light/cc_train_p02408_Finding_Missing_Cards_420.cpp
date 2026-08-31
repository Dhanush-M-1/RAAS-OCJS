#include <cstdio>

const char S[5] = "SHCD";

int main(){
    bool h[4][13];
    for(int i = 0; i<52; i++){
        h[i/13][i%13] = false;
    }
    int n, x;
    char c;
    scanf("%d", &n);
    for(int i = 0; i<n; i++){
        scanf(" %c %d", &c, &x);
        for(int j = 0; j<4; j++){
            if(S[j] == c){
                h[j][x-1] = true;
            }
        }
    }
    for(int i = 0; i<4; i++){
        for(int j = 0; j < 13; j++){
            if(!h[i][j]){
                printf("%c %d\n", S[i], j+1);
            }
        }
    }
    return 0;
}
