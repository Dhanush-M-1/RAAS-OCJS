#include <bits/stdc++.h>
using namespace std;

 bool cards[4][13];

int main(){
  int n; cin >> n;

  string suit = "SHCD";
  for(int i=0; i<n; i++){
    char M; cin >> M;
    int R; cin >> R;
    cards[suit.find(M)][R-1] = 1;
  }
  for(int i=0; i<4; i++){
    for(int j=0; j<13; j++){
      if(cards[i][j] == 0){
        cout << suit[i] << " " << j+1 << endl;
      }
    }
  }
  return 0;
}