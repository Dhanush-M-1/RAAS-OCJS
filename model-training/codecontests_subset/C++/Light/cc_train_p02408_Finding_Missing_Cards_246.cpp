#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for(int i = 0; i < (int)(n); i++)
typedef long long ll;

int main(){
  int n;
  cin >> n;
  vector<vector<int>> t(4, vector<int>(13));
  vector<char> a={'S', 'H', 'C', 'D'};
  rep(i, n){
    char c;
    int k;
    cin >> c >> k;
    if(c=='S') t[0][k-1]++;
    if(c=='H') t[1][k-1]++;
    if(c=='C') t[2][k-1]++;
    if(c=='D') t[3][k-1]++;
  }

  rep(i, 4){
    rep(j, 13){
      if(t[i][j]==0) cout << a[i] << " " << j+1 << endl;
    }
  }

  return 0;
}
