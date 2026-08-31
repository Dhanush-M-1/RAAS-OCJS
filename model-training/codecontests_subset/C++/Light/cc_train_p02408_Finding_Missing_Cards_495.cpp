#include <iostream>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;
typedef long long ll;

int main(){
  int n, x, y;
  int card[4][13] = {};
  string s, t;
  t = "SHCD";
  cin >> n;
  for (int i = 0; i < n; i++){
  	cin >> s >> y;
    x = t.find(s);
    card[x][y-1] = 1;
  }
  
  for (int i = 0; i < 4; i++){
  	for (int j = 0; j < 13; j++){
    	if (card[i][j] == 0) cout << t[i] << " " << j+1 << endl;
    }
  }
  return 0;
}
