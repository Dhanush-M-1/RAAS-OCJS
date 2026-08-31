#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> g1;
  long long int n, m;
  cin >> n >> m;
  long long int i = 0;
  while (i < n) {
    long long int k;
    cin >> k;
    long long int j = 0;
    while (j < k) {
      long long int h;
      cin >> h;
      g1.push_back(h);
      j++;
    }
    i++;
  }
  sort(g1.begin(), g1.end());
  g1.erase(unique(g1.begin(), g1.end()), g1.end());
  if (g1.size() == m) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
