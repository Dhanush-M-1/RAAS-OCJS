#include <bits/stdc++.h>
using namespace std;

int main(){
  int n,N;
  string suit;
  int card[4][13] = {0};
  cin >> n;
  for(int i = 0;i < n;i++){
    cin >> suit >> N;
    if(suit == "S") card[0][N-1] = 1;
    if(suit == "H") card[1][N-1] = 1;
    if(suit == "C") card[2][N-1] = 1;
    if(suit == "D") card[3][N-1] = 1;
  }
  string str[4] = {"S","H","C","D"};
  for(int i =0;i < 4;i++){
    for(int j =0;j < 13;j++){
      if(card[i][j] == 0)
	cout<< str[i] << ' ' << j + 1 << endl;
    }
  }
  return 0;
}

