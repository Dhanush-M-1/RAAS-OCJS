#include <iostream>
using namespace std;

int cards[4*13];
int main(void){
  int suitID[127];
  int n;
  suitID['S']=0; suitID['H']=1;
  suitID['C']=2; suitID['D']=3;
  cin >> n;
  for (int i=0; i<n; i++){
    char s;
    int r;
    cin >> s >> r;
    cards[suitID[s]*13+r-1]=1;
  }
  for (int i=0; i<52; i++){
    int s,r;
    if (cards[i]) continue;
    s = i/13; r = i%13+1;
    cout << "SHCD"[s] << " " << r << endl;
  }
  return 0;
}

