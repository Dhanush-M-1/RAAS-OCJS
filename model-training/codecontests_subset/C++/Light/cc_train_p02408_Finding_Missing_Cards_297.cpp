#include <cstdio>

using namespace std;

int main() {
    size_t n;
    scanf("%zu\n", &n);

    char suits[]="SHCD";
    int encode[256]={};
    for (size_t i=0; i<4; ++i)
        encode[suits[i]+0] = i;

    bool card[4][14]={};
    for (size_t i=0; i<n; ++i) {
        char suit;
        int rank_;
        scanf("%c %d\n", &suit, &rank_);
        card[encode[suit+0]][rank_] = true;
    }

    for (size_t i=0; i<4; ++i)
        for (size_t j=1; j<=13; ++j)
            if (!card[i][j])
                printf("%c %zu\n", suits[i], j);

    return 0;
}