#include <bits/stdc++.h>
using namespace std;

int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  
  int n, m;
  cin >> n >> m;
  
  vector<int> x(n + 1, 1);
  int a;
  for(int i = 0; i < m; i++){
    cin >> a;
    x.at(a) = 0;
  }
  
  x.at(1) *= x.at(0);
  for(int i = 2; i <= n; i++){
    x.at(i) *= x.at(i - 1) + x.at(i - 2);
    x.at(i) %= (int) 1e9 + 7;
  }
  
  cout << x.at(n) << "\n";
}