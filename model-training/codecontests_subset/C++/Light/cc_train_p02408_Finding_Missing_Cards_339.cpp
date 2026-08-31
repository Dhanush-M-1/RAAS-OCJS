#include<bits/stdc++.h>
using namespace std;

int main(){
int cards[4][13] = {0};
string suit = "SHCD";
int n,A,b;
char a;
cin >> n;


for(int i = 0;i < n;i++){
  cin >> a >> b;
  switch (a)
  {
  case 'S':
    cards[0][b-1] = 1;
    break;
  case 'H':
    cards[1][b-1] = 1;
    break;
  case 'C':
    cards[2][b-1] = 1;
    break;
  default:
    cards[3][b-1] = 1;
    break;
  }
}



for(int i = 0;i < 4;i++){
  for(int j = 0;j < 13;j++){
    if(cards[i][j] == 0){
      cout << suit[i] << " " << j + 1 << endl;
    }
  }
}
return 0;
}
