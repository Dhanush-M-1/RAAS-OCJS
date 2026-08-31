#include<iostream>
#define REP(i, n) for (int i = 0; i < (int)(n); ++i)

using namespace std;

char suits[4] = {'S', 'H', 'C', 'D'};
int cards[4][13] = {0};

int main() {
  int n; cin >> n;
  REP(i, n) {
    char suit;
    int rank;
    cin >> suit >> rank;
    REP(j, 4) {
      if (suits[j] == suit) cards[j][rank - 1] = 1;
    }
  }
  REP(i, 4) {
    REP(j, 13) {
      if (cards[i][j] == 0) printf("%c %d\n", suits[i], j + 1);
    }
  }
}
