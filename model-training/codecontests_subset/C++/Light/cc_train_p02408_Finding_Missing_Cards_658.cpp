#include<bits/stdc++.h>
using namespace std;

int main(){
  map<char, int>mp = {
    {'S', 0}, 
    {'H', 1}, 
    {'C', 2}, 
    {'D', 3}, 
  };
  string mark = "SHCD";
  vector<vector<int>> a(4, vector<int>(13, 0));
  int n;
  cin >> n;
  for(int i = 0; i < n; i++){
    char c; cin >> c;
    int x; cin >> x;
    a[mp[c]][x - 1] = 1;
  }
  for(int i = 0; i < 4; i++){
    for(int j = 0; j < 13; j++){
      if(!a[i][j]){
        cout << mark[i] << " " << j + 1 << endl;
      }
    }
  }
}
